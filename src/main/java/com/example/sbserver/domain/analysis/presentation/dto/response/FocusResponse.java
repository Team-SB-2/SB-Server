package com.example.sbserver.domain.analysis.presentation.dto.response;

import com.example.sbserver.domain.record.domain.repository.vo.FocusVo;
import lombok.Builder;
import lombok.Getter;
import lombok.Setter;

@Getter
@Builder
@Setter
public class FocusResponse {
    private final String title;
    private final String emoji;
    private final int sum;
    private int focusedRatio;

    public static FocusResponse of(FocusVo focusVo) {
        return FocusResponse.builder()
                .title(focusVo.getTitle())
                .emoji(focusVo.getEmoji())
                .sum(focusVo.getSum())
                .build();
    }

    public FocusResponse updateFocusRatio(int focusedRatio) {
        this.focusedRatio = focusedRatio;
        return this;
    }
}