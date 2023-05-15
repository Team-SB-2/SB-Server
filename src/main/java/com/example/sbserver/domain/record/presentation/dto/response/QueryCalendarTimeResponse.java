package com.example.sbserver.domain.record.presentation.dto.response;

import lombok.AllArgsConstructor;
import lombok.Getter;

@Getter
@AllArgsConstructor
public class QueryCalendarTimeResponse {
    private final Integer totalFocusedTime;
    private final Integer maxFocusedTime;
}
