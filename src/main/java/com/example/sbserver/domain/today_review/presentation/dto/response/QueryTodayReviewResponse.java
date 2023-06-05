package com.example.sbserver.domain.today_review.presentation.dto.response;

import lombok.AllArgsConstructor;
import lombok.Getter;

@Getter
@AllArgsConstructor
public class QueryTodayReviewResponse {
    private final Long reviewId;
    private final String content;
}
