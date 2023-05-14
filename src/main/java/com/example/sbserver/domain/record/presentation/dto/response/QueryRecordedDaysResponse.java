package com.example.sbserver.domain.record.presentation.dto.response;

import lombok.AllArgsConstructor;
import lombok.Getter;

import java.util.List;

@Getter
@AllArgsConstructor
public class QueryRecordedDaysResponse {
    private List<Integer> recordedDays;
}
