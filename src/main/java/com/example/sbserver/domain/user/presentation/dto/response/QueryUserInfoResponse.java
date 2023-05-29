package com.example.sbserver.domain.user.presentation.dto.response;

import com.example.sbserver.domain.user.domain.Sex;
import com.example.sbserver.domain.user.domain.User;
import lombok.Builder;
import lombok.Getter;

@Getter
@Builder
public class QueryUserInfoResponse {

    private final String email;
    private final String name;
    private final Integer age;
    private final Sex sex;

    public static QueryUserInfoResponse of(User user) {
        return QueryUserInfoResponse.builder()
                .name(user.getEmail())
                .build();
    }
}