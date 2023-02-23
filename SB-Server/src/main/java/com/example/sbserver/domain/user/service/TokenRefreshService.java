package com.example.sbserver.domain.user.service;

import com.example.sbserver.domain.auth.domain.RefreshToken;
import com.example.sbserver.domain.auth.domain.repository.RefreshTokenRepository;
import com.example.sbserver.domain.auth.dto.response.TokenResponse;
import com.example.sbserver.domain.user.domain.User;
import com.example.sbserver.domain.user.facade.UserFacade;
import com.example.sbserver.global.exception.RefreshTokenNotFoundException;
import com.example.sbserver.global.security.jwt.JwtParser;
import com.example.sbserver.global.security.jwt.JwtProperties;
import com.example.sbserver.global.security.jwt.JwtTokenProvider;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import javax.transaction.Transactional;


@Service
@RequiredArgsConstructor
public class TokenRefreshService {
    private final JwtTokenProvider jwtTokenProvider;
    private final RefreshTokenRepository refreshTokenRepository;
    private final JwtProperties jwtProperties;
    private final UserFacade userFacade;


    @Transactional
    public TokenResponse execute(String refreshToken) {
        return reIssue(refreshToken);
    }

    private TokenResponse reIssue(String refreshToken) {

        RefreshToken redisRefreshToken = refreshTokenRepository.findByToken(refreshToken)
                .orElseThrow(() -> RefreshTokenNotFoundException.EXCEPTION);

        User user = userFacade.getCurrentUser();

        String email = redisRefreshToken.getEmail();

        String accessToken = jwtTokenProvider.generateAccessToken(email,user.getRole().toString());
        String newRefreshToken = jwtTokenProvider.generateRefreshToken(email, user.getRole().toString());

        redisRefreshToken.updateToken(newRefreshToken, jwtProperties.getRefreshExp());

        return TokenResponse.builder()
                .accessToken(accessToken)
                .refreshToken(newRefreshToken)
                .build();
    }
}
