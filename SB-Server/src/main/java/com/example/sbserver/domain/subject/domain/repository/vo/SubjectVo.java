package com.example.sbserver.domain.subject.domain.repository.vo;

import com.querydsl.core.annotations.QueryProjection;
import lombok.Getter;

@Getter
public class SubjectVo {
    private final Long subjectId;
    private final String title;
    private final String emoji;
    private final Long userId;
    private final int todayRecord;

    @QueryProjection
    public SubjectVo(Long subjectId, String title, String emoji, Long userId, int todayRecord) {
        this.subjectId = subjectId;
        this.title = title;
        this.emoji = emoji;
        this.userId = userId;
        this.todayRecord = todayRecord;
    }
}
