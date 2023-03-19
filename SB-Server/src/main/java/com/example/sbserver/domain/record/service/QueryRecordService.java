package com.example.sbserver.domain.record.service;

import com.example.sbserver.domain.record.domain.repository.RecordRepository;
import com.example.sbserver.domain.record.domain.repository.vo.RecordVo;
import com.example.sbserver.domain.record.presentation.dto.response.QueryRecordListResponse;
import com.example.sbserver.domain.user.domain.User;
import com.example.sbserver.domain.user.facade.UserFacade;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.time.LocalDate;
import java.util.List;
import java.util.stream.Collectors;

@RequiredArgsConstructor
@Service
public class QueryRecordService {
    private final RecordRepository recordRepository;
    private final UserFacade userFacade;

    @Transactional(readOnly = true)
    public QueryRecordListResponse execute(LocalDate date) {
        User user = userFacade.getCurrentUser();
        List<RecordVo> recordVoList = recordRepository.findByFinishedDateAndUser(date, user);

        return QueryRecordListResponse.builder()
                .date(date)
                .recordResponses(
                        recordVoList.stream().map(
                                        record -> QueryRecordListResponse.RecordResponse.builder()
                                                .recordId(record.getRecordId())
                                                .startedTime(record.getStartedTime())
                                                .finishedTime(record.getFinishedTime())
                                                .total(record.getTotal())
                                                .memo(record.getMemo())
                                                .subject(QueryRecordListResponse.SubjectElement.builder()
                                                        .title(record.getTitle())
                                                        .emoji(record.getEmoji())
                                                        .subjectId(record.getSubjectId())
                                                        .build())

                                                .build()
                                )
                                .collect(Collectors.toList())
                )
                .build();

    }

}
