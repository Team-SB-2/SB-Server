package com.example.sbserver.domain.tips.presentation.dto.response;

import lombok.Builder;
import lombok.Getter;

@Getter
@Builder
public class QueryTipsResponse {
    private final String title;
    private final String content;
}
