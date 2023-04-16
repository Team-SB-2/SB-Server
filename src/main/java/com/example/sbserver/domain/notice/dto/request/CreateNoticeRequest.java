package com.example.sbserver.domain.notice.dto.request;

import lombok.Getter;
import lombok.NoArgsConstructor;

@Getter
@NoArgsConstructor
public class CreateNoticeRequest {
    private String title;
    private String content;
}
