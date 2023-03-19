package com.example.sbserver.domain.record.service;

import com.example.sbserver.domain.record.domain.Record;
import com.example.sbserver.domain.record.domain.repository.RecordRepository;
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
import java.time.LocalDateTime;
import java.time.temporal.ChronoUnit;
import java.util.Date;

@RequiredArgsConstructor
@Service
public class CreateRecordService {
    private final RecordRepository recordRepository;
    private final SubjectRepository subjectRepository;
    private final UserFacade userFacade;

    @Transactional
    public void execute(Long id, CreateRecordRequest request) {
        User user = userFacade.getCurrentUser();
        Subject subject = subjectRepository.findById(id)
                .orElseThrow(() -> SubjectNotFoundException.EXCEPTION);

        recordRepository.save(
                Record.builder()
                        .startedTime(request.getStartedTime())
                        .finishedTime(request.getFinishedTime())
                        .subject(subject)
                        .total(getDifference(request.getStartedTime(), request.getFinishedTime()))
                        .user(user)
                        .build()
        );
    }

    private int getDifference(LocalDateTime dateTime1, LocalDateTime dateTime2) {
        long nanoSecondDiff = ChronoUnit.SECONDS.between(dateTime1, dateTime1);
        return Math.abs((int) nanoSecondDiff);
    }
}
