package com.example.sbserver.domain.record.domain.repository.vo;

import com.querydsl.core.annotations.QueryProjection;
import lombok.Getter;

@Getter
public class FocusVo {
    private final String title;
    private final String emoji;
    private final int sum;

    @QueryProjection
    public FocusVo(String title, String emoji, int sum) {
        this.title = title;
        this.emoji = emoji;
        this.sum = sum;
    }
}
