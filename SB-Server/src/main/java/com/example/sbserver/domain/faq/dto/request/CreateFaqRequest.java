package com.example.sbserver.domain.faq.dto.request;

import lombok.Getter;
import lombok.NoArgsConstructor;

@Getter
@NoArgsConstructor
public class CreateFaqRequest {
    private String title;
    private String content;
}
