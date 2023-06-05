package com.example.sbserver.domain.record.presentation.dto.response;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Getter;

import java.time.LocalDateTime;

@Getter
@Builder
public class QueryRecordInfoResponse {
    private final Long recordId;
    private final LocalDateTime startedTime;
    private final LocalDateTime finishedTime;
    private final Integer total;
    private final String memo;
}
