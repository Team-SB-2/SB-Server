package com.example.sbserver.domain.faq.presentation.dto.response;

import lombok.Builder;
import lombok.Getter;

@Getter
@Builder
public class QueryFaqResponse {
    private final String title;
    private final String content;
}
