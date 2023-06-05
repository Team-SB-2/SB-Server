package com.example.sbserver.domain.record.service;

import com.example.sbserver.domain.record.domain.Record;
import com.example.sbserver.domain.record.domain.repository.RecordRepository;
import com.example.sbserver.domain.record.exception.RecordNotFoundException;
import com.example.sbserver.domain.record.presentation.dto.response.QueryRecordInfoResponse;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

@RequiredArgsConstructor
@Service
public class QueryRecordInfoService {
    private final RecordRepository recordRepository;

    public QueryRecordInfoResponse execute(Long recordId) {
        Record record = recordRepository.findById(recordId)
                .orElseThrow(() -> RecordNotFoundException.EXCEPTION);

        return QueryRecordInfoResponse.builder()
                .recordId(record.getId())
                .startedTime(record.getStartedTime())
                .finishedTime(record.getFinishedTime())
                .total(record.getTotal())
                .memo(record.getMemo())
                .build();
    }
}
