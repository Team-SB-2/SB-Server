package com.example.sbserver.domain.analysis.presentation.dto.response;

import com.example.sbserver.domain.record.domain.repository.vo.FocusVo;
import lombok.Builder;
import lombok.Getter;

@Getter
@Builder
public class FocusResponse {
    private final String title;
    private final String emoji;
    private final int sum;

    public static FocusResponse of(FocusVo focusVo) {
        return FocusResponse.builder()
                .title(focusVo.getTitle())
                .emoji(focusVo.getEmoji())
                .sum(focusVo.getSum())
                .build();
    }
}