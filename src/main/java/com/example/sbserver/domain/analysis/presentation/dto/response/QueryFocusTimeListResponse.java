package com.example.sbserver.domain.analysis.presentation.dto.response;

import lombok.Builder;
import lombok.Getter;

import java.time.YearMonth;
import java.util.List;

@Getter
@Builder
public class QueryFocusTimeListResponse {
    private final YearMonth yearMonth;
    private final Integer totalTime;
    private final List<FocusResponse> focusResponses;
}
