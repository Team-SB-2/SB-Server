package com.example.sbserver.domain.user.presentation.dto.request;

import com.example.sbserver.domain.user.domain.Sex;
import lombok.Getter;
import lombok.NoArgsConstructor;

import javax.validation.constraints.NotBlank;
import javax.validation.constraints.Size;

@Getter
@NoArgsConstructor
public class UpdateUserInfoRequest {

    @NotBlank(message = "name은 Null 또는 공백을 허용하지 않습니다.")
    @Size(max = 10, message = "name은 10자 이내여야 합니다.")
    private String name;

    private Integer age;

    private Sex sex;
}
