package com.example.sbserver.domain.record.domain.repository.vo;

import com.querydsl.core.annotations.QueryProjection;
import lombok.Getter;

@Getter
public class CalendarTimeVo {
    private final Integer totalFocusedTime;
    private final Integer maxFocusedTime;

    @QueryProjection
    public CalendarTimeVo(Integer totalFocusedTime, Integer maxFocusedTime) {
        this.totalFocusedTime = totalFocusedTime;
        this.maxFocusedTime = maxFocusedTime;
    }
}
