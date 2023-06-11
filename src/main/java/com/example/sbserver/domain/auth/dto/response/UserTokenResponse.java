package com.example.sbserver.domain.auth.dto.response;

import lombok.AllArgsConstructor;
import lombok.Getter;

@Getter
@AllArgsConstructor
public class UserTokenResponse {
    private final TokenResponse tokenResponse;
    private final String email;
    private final String password;
}
