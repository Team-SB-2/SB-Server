package com.example.sbserver.domain.subject.presentation.dto.request;

import lombok.Getter;
import lombok.NoArgsConstructor;

import javax.validation.constraints.NotBlank;
import javax.validation.constraints.Size;

@NoArgsConstructor
@Getter
public class CreateSubjectRequest {

    @NotBlank(message = "title은 앞글자 띄어쓰기, Null을 허용하지 않습니다")
    @Size(min = 1, max = 20, message = "title은 1~20글자 이내여야 합니다")
    private String title;

    private String emoji;
}
