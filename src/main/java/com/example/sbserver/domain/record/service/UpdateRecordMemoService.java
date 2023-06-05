package com.example.sbserver.domain.record.service;

import com.example.sbserver.domain.record.domain.Record;
import com.example.sbserver.domain.record.domain.repository.RecordRepository;
import com.example.sbserver.domain.record.exception.RecordNotFoundException;
import com.example.sbserver.domain.record.presentation.dto.request.UpdateRecordMemoRequest;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

@RequiredArgsConstructor
@Service
public class UpdateRecordMemoService {
    private final RecordRepository recordRepository;

    @Transactional
    public void execute(Long recordId, UpdateRecordMemoRequest request) {
        Record record = recordRepository.findById(recordId)
                .orElseThrow(() -> RecordNotFoundException.EXCEPTION);

        record.updateMemo(request.getMemo());
    }
}
