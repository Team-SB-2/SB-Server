package com.example.sbserver.domain.record.presentation.dto;

import com.example.sbserver.domain.record.presentation.dto.request.CreateRecordRequest;
import com.example.sbserver.domain.record.presentation.dto.response.QueryCalendarTimeResponse;
import com.example.sbserver.domain.record.presentation.dto.response.QueryRecordListResponse;
import com.example.sbserver.domain.record.presentation.dto.response.QueryRecordedDaysResponse;
import com.example.sbserver.domain.record.service.CreateRecordService;
import com.example.sbserver.domain.record.service.QueryCalendarTimeService;
import com.example.sbserver.domain.record.service.QueryRecordService;
import com.example.sbserver.domain.record.service.QueryRecordedDaysService;
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
}
