package com.example.sbserver.domain.record.presentation.dto.response;

import com.fasterxml.jackson.annotation.JsonFormat;
import com.fasterxml.jackson.annotation.JsonProperty;
import lombok.Builder;
import lombok.Getter;

import java.time.LocalDate;
import java.time.LocalDateTime;
import java.util.List;

@Getter
@Builder
public class QueryRecordListResponse {
    private final LocalDate date;
    private final List<RecordResponse> recordResponses;

    @Getter
    @Builder
    public static class RecordResponse {
        private final Long recordId;

        private final LocalDateTime startedTime;

        private final LocalDateTime finishedTime;

        private final Integer total;

        private final String memo;

        @JsonProperty("is_record")
        private final boolean isRecord;

        private final SubjectElement subject;
    }

    @Getter
    @Builder
    public static class SubjectElement {
        private final Long subjectId;
        private final String title;
        private final String emoji;
    }
}

