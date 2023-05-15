package com.example.sbserver.domain.record.presentation.dto.response;

import lombok.AllArgsConstructor;
import lombok.Getter;

import java.time.YearMonth;
import java.util.List;

@Getter
@AllArgsConstructor
public class QueryRecordedDaysResponse {
    private YearMonth yearMonth;
    private List<Integer> recordedDays;
}
