package com.example.sbserver.domain.notice.dto.request;

import lombok.Getter;
import lombok.NoArgsConstructor;

@Getter
@NoArgsConstructor
public class UpdateNoticeRequest {
    private String title;
    private String content;
}
