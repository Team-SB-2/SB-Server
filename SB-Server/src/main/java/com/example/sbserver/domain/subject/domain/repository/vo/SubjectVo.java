package com.example.sbserver.domain.subject.domain.repository.vo;

import com.example.sbserver.domain.subject.domain.Subject;
import com.example.sbserver.domain.user.domain.User;
import com.querydsl.core.annotations.QueryProjection;
import lombok.Getter;

@Getter
public class SubjectVo {
    private final Long postId;
    private final String title;
    private final String emoji;
    private final Long userId;

    @QueryProjection
    public SubjectVo(Subject subject, User user) {
        this.postId = subject.getId();
        this.title = subject.getTitle();
        this.emoji = subject.getEmoji();
        this.userId = user.getId();
    }
}
