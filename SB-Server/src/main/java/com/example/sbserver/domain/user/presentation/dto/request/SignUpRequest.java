package com.example.sbserver.domain.user.presentation.dto.request;

import com.example.sbserver.domain.user.domain.Sex;
import lombok.Getter;
import lombok.NoArgsConstructor;

import javax.validation.constraints.Email;
import javax.validation.constraints.NotBlank;
import javax.validation.constraints.Pattern;
import javax.validation.constraints.Size;

@NoArgsConstructor
@Getter
public class SignUpRequest {
    @Email(message = "이메일 형식을 맞춰 주세요")
    private String email;

    @NotBlank(message = "password는 Null 또는 공백 또는 띄어쓰기를 허용하지 않습니다.")
    @Pattern(regexp = "(?=.*[a-z])(?=.*[0-9])(?=.*[~!@#$%^&*()_+-=?/])[a-zA-Z0-9~!@#$%^&*()_+-=?/]{8,30}$", message = "password는 8-30자여야합니다.")
    private String password;

    @NotBlank(message = "name은 Null 또는 공백을 허용하지 않습니다.")
    @Size(max = 10, message = "name은 10자 이내여야 합니다.")
    private String name;

    private Integer age;

    private Sex sex;
}
