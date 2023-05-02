package com.example.sbserver.domain.subject.presentation.dto.response;

import lombok.Builder;
import lombok.Getter;

import java.util.List;

@Getter
@Builder
public class QuerySubjectListResponse {
    private final int totalTime;
    private final List<QuerySubjectResponse> subjectList;
}
