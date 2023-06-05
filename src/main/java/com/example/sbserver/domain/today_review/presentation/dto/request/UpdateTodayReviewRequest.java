package com.example.sbserver.domain.today_review.presentation.dto.request;

import lombok.Getter;
import lombok.NoArgsConstructor;

import javax.validation.constraints.Size;

@Getter
@NoArgsConstructor
public class UpdateTodayReviewRequest {

    @Size(max = 20, message = "content는 20자 까지입니다")
    private String content;
}
