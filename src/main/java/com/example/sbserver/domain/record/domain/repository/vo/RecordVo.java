package com.example.sbserver.domain.record.domain.repository.vo;

import com.example.sbserver.domain.record.domain.Record;
import com.example.sbserver.domain.subject.domain.Subject;
import com.example.sbserver.domain.user.domain.User;
import com.querydsl.core.annotations.QueryProjection;
import lombok.Getter;

import java.time.LocalDateTime;

@Getter
public class RecordVo {

    private final Long recordId;
    private final LocalDateTime startedTime;
    private final LocalDateTime finishedTime;
    private final Integer total;
    private final String memo;
    private final Long subjectId;
    private final String title;
    private final String emoji;
    private final boolean isRecord;

    @QueryProjection
    public RecordVo(Record record, Subject subject) {
        this.recordId = record.getId();
        this.startedTime = record.getStartedTime();
        this.finishedTime = record.getFinishedTime();
        this.total = record.getTotal();
        this.memo = record.getMemo();
        this.subjectId = subject.getId();
        this.title = subject.getTitle();
        this.emoji = subject.getEmoji();
        this.isRecord = record.getIsRecord();
    }
}
