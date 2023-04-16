package com.example.sbserver.domain.subject.presentation.dto.response;

import lombok.Builder;
import lombok.Getter;

@Getter
@Builder
public class QuerySubjectResponse {
    private final Long id;
    private final String title;
    private final String emoji;
    private final Long userId;
    private final int todayRecord;
}
