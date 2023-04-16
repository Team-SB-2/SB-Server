package com.example.sbserver.domain.tips.dto.request;

import lombok.Getter;
import lombok.NoArgsConstructor;

@Getter
@NoArgsConstructor
public class CreateTipRequest {
    private String title;
    private String content;
}
