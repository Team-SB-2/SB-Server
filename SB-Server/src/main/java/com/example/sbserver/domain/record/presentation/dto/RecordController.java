package com.example.sbserver.domain.record.presentation.dto;

import com.example.sbserver.domain.record.presentation.dto.request.CreateRecordRequest;
import com.example.sbserver.domain.record.presentation.dto.response.QueryRecordListResponse;
import com.example.sbserver.domain.record.service.CreateRecordService;
import com.example.sbserver.domain.record.service.QueryRecordService;
import lombok.RequiredArgsConstructor;
import org.springframework.format.annotation.DateTimeFormat;
import org.springframework.web.bind.annotation.*;

import java.time.LocalDate;

@RequiredArgsConstructor
@RestController
@RequestMapping("/record")
public class RecordController {
    private final CreateRecordService createRecordService;
    private final QueryRecordService queryRecordService;

    @PostMapping("/{subject-id}")
    public void createRecord(@PathVariable("subject-id") Long id, @RequestBody CreateRecordRequest request) {
        createRecordService.execute(id, request);
    }

    @GetMapping
    public QueryRecordListResponse queryRecord(@RequestParam @DateTimeFormat(pattern = "yyyy-MM-dd")LocalDate date) {
        return queryRecordService.execute(date);
    }
}
