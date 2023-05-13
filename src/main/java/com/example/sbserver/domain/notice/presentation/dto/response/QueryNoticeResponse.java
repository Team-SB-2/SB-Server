package com.example.sbserver.domain.notice.presentation.dto.response;

import lombok.Builder;
import lombok.Getter;

import java.time.LocalDateTime;

@Getter
@Builder
public class QueryNoticeResponse {
    private final String title;
    private final String content;
    private final LocalDateTime createdAt;
}
