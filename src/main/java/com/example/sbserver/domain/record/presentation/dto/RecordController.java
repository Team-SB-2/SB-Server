package com.example.sbserver.domain.record.presentation.dto;

import com.example.sbserver.domain.record.presentation.dto.request.CreateRecordRequest;
import com.example.sbserver.domain.record.presentation.dto.request.UpdateRecordMemoRequest;
import com.example.sbserver.domain.record.presentation.dto.response.QueryCalendarTimeResponse;
import com.example.sbserver.domain.record.presentation.dto.response.QueryRecordInfoResponse;
import com.example.sbserver.domain.record.presentation.dto.response.QueryRecordListResponse;
import com.example.sbserver.domain.record.presentation.dto.response.QueryRecordedDaysResponse;
import com.example.sbserver.domain.record.service.*;
import com.fasterxml.jackson.annotation.JsonFormat;
import lombok.RequiredArgsConstructor;
import org.springframework.format.annotation.DateTimeFormat;
import org.springframework.web.bind.annotation.*;

import javax.validation.Valid;
import java.time.LocalDate;
import java.time.YearMonth;

@RequiredArgsConstructor
@RestController
@RequestMapping("/record")
public class RecordController {
    private final CreateRecordService createRecordService;
    private final QueryRecordService queryRecordService;
    private final QueryRecordedDaysService queryRecordedDaysService;
    private final QueryCalendarTimeService queryCalendarTimeService;
    private final QueryRecordInfoService queryRecordInfoService;
    private final UpdateRecordMemoService updateRecordMemoService;

    @PostMapping("/{subject-id}")
    public void createRecord(@PathVariable("subject-id") Long id, @Valid @RequestBody CreateRecordRequest request) {
        createRecordService.execute(id, request);
    }

    @GetMapping
    public QueryRecordListResponse queryRecord(@RequestParam @DateTimeFormat(pattern = "yyyy-MM-dd")LocalDate date) {
        return queryRecordService.execute(date);
    }

    @GetMapping("/calendar")
    public QueryRecordedDaysResponse queryRecordedDays(@RequestParam("yearMonth") String yearMonthStr) {
        return queryRecordedDaysService.execute(yearMonthStr);
    }

    @GetMapping("/calendar/time")
    public QueryCalendarTimeResponse queryCalendarTime(@RequestParam @DateTimeFormat(pattern = "yyyy-MM-dd") LocalDate date) {
        return queryCalendarTimeService.execute(date);
    }

    @GetMapping("/{record-id}")
    public QueryRecordInfoResponse queryRecordInfo(@PathVariable("record-id")Long id) {
        return queryRecordInfoService.execute(id);
    }

    @PatchMapping("/{record-id}")
    public void updateMemo(@PathVariable("record-id")Long id, @Valid @RequestBody UpdateRecordMemoRequest request) {
        updateRecordMemoService.execute(id, request);
    }
}
