package com.example.sbserver.domain.analysis.presentation.dto.response;

import lombok.Builder;
import lombok.Getter;

import java.time.Month;

@Getter
@Builder
public class QueryFocusGraphResponse {
    private final Month lastMonth;
    private final Month thisMonth;
    private final Integer growthPercent;
    private final Integer increasedTime;
}
