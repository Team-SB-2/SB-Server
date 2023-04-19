package com.example.sbserver.domain.record.service;

import com.example.sbserver.domain.record.domain.Record;
import com.example.sbserver.domain.record.domain.repository.RecordRepository;
import com.example.sbserver.domain.record.exception.RecordDeadLineExceedException;
import com.example.sbserver.domain.record.exception.RecordOutOfRangeException;
import com.example.sbserver.domain.record.presentation.dto.request.CreateRecordRequest;
import com.example.sbserver.domain.subject.domain.Subject;
import com.example.sbserver.domain.subject.domain.repository.SubjectRepository;
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

@RequiredArgsConstructor
@Service
public class CreateRecordService {
    private static final int TIME_RANGE = 86399;
    private static final LocalDateTime STANDARD_TIME = LocalDate.now().atTime(5, 0);

    private final RecordRepository recordRepository;
    private final SubjectRepository subjectRepository;
    private final UserFacade userFacade;

    @Transactional
    public void execute(Long id, CreateRecordRequest request) {
        checkIsRecordWithinTimeRange(request.getStartedTime(), request.getFinishedTime());

        User user = userFacade.getCurrentUser();
        Subject subject = subjectRepository.findById(id).orElseThrow(() -> SubjectNotFoundException.EXCEPTION);

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
                        .user(user)
                        .build()
        );
    }

    private int getDifference(LocalDateTime dateTime1, LocalDateTime dateTime2) {
        long nanoSecondDiff = ChronoUnit.SECONDS.between(dateTime1, dateTime2);
        return Math.abs((int) nanoSecondDiff);
    }

    private void checkIsRecordWithinTimeRange(LocalDateTime startedTime, LocalDateTime finishedTime) {

        if (startedTime.isBefore(STANDARD_TIME) && finishedTime.isAfter(STANDARD_TIME)) {
            throw RecordDeadLineExceedException.EXCEPTION;
        }
    }
}
