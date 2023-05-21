package com.example.sbserver.domain.record.service;

import com.example.sbserver.domain.record.domain.Record;
import com.example.sbserver.domain.record.domain.repository.RecordRepository;
import com.example.sbserver.domain.record.exception.RecordDeadLineExceedException;
import com.example.sbserver.domain.record.exception.RecordOutOfRangeException;
import com.example.sbserver.domain.record.presentation.dto.request.CreateRecordRequest;
import com.example.sbserver.domain.subject.domain.Subject;
import com.example.sbserver.domain.subject.domain.repository.SubjectRepository;
import com.example.sbserver.domain.subject.exception.NoPermissionException;
import com.example.sbserver.domain.subject.exception.SubjectNotFoundException;
import com.example.sbserver.domain.user.domain.User;
import com.example.sbserver.domain.user.facade.UserFacade;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.text.SimpleDateFormat;
import java.time.LocalDate;
import java.time.LocalDateTime;
import java.time.LocalTime;
import java.time.temporal.ChronoUnit;
import java.util.Date;
import java.util.Optional;

@RequiredArgsConstructor
@Service
public class CreateRecordService {
    private static final int TIME_RANGE = 86399;
    private final RecordRepository recordRepository;
    private final SubjectRepository subjectRepository;
    private final UserFacade userFacade;

    @Transactional
    public void execute(Long id, CreateRecordRequest request) {
        checkIsRecordWithinTimeRange(request.getStartedTime(), request.getFinishedTime());

        User user = userFacade.getCurrentUser();
        Subject subject = subjectRepository.findById(id).orElseThrow(() -> SubjectNotFoundException.EXCEPTION);

        if (!subject.getUser().equals(user)) {
            throw NoPermissionException.EXCEPTION;
        }

        LocalDateTime startedTime = request.getStartedTime().with(LocalTime.MIN);

        if(recordRepository.existsByUser(user)) {
            LocalDateTime lastStartedTime = recordRepository.findLastRecordByUser(user).getFinishedTime().plusMinutes(1);

            if(lastStartedTime.isAfter(startedTime))
                startedTime = lastStartedTime;
        }

        LocalDateTime finishedTime = request.getStartedTime().minusMinutes(1);

        recordRepository.save(
                Record.builder()
                        .startedTime(startedTime)
                        .finishedTime(finishedTime)
                        .total(getDifference(startedTime, finishedTime))
                        .isRecord(false)
                        .subject(subject)
                        .user(user)
                        .build()
        );

        int total = getDifference(request.getStartedTime(), request.getFinishedTime());

        if (total > TIME_RANGE) {
            throw RecordOutOfRangeException.EXCEPTION;
        }

        recordRepository.save(
                Record.builder()
                        .startedTime(request.getStartedTime())
                        .finishedTime(request.getFinishedTime())
                        .subject(subject)
                        .total(total)
                        .memo(request.getMemo())
                        .isRecord(true)
                        .user(user)
                        .build()
        );
    }

    private int getDifference(LocalDateTime dateTime1, LocalDateTime dateTime2) {
        long nanoSecondDiff = ChronoUnit.SECONDS.between(dateTime1, dateTime2);
        return Math.abs((int) nanoSecondDiff);
    }

    private void checkIsRecordWithinTimeRange(LocalDateTime startedTime, LocalDateTime finishedTime) {
        LocalDateTime standardTime = finishedTime.with(LocalDateTime.MIN);

        if (startedTime.isBefore(standardTime) && finishedTime.isAfter(standardTime)) {
            throw RecordDeadLineExceedException.EXCEPTION;
        }
    }
}
