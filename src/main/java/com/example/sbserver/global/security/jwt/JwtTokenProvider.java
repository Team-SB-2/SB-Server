package com.example.sbserver.global.security.jwt;

import com.example.sbserver.domain.auth.domain.RefreshToken;
import com.example.sbserver.domain.auth.domain.repository.RefreshTokenRepository;
import com.example.sbserver.domain.auth.dto.response.TokenResponse;
import io.jsonwebtoken.Jwts;
import io.jsonwebtoken.SignatureAlgorithm;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Component;

import java.util.Date;

@Component
@RequiredArgsConstructor
public class JwtTokenProvider {

    private static final String ACCESS_KEY = "access";
    private static final String REFRESH_KEY = "refresh";

    private final RefreshTokenRepository refreshTokenRepository;
    private final JwtProperties jwtProperties;

    public TokenResponse getToken(String email, String role) {
        return TokenResponse.builder()
                .accessToken(generateAccessToken(email, role))
                .refreshToken(generateRefreshToken(email, role))
                .build();
    }

    public String generateAccessToken(String email, String role) {
        return generateToken(email, role, ACCESS_KEY, jwtProperties.getAccessExp());
    }

    public String generateRefreshToken(String email, String role) {
        String refreshToken =  generateToken(email, role, REFRESH_KEY, jwtProperties.getRefreshExp());

        refreshTokenRepository.save(RefreshToken.builder()
                .email(email)
                .token(refreshToken)
                .ttl(jwtProperties.getRefreshExp() * 1000)
                .build());

        return refreshToken;
    }

    private String generateToken(String email, String role, String type, Long exp) {
        return Jwts.builder()
                .signWith(SignatureAlgorithm.HS256, jwtProperties.getSecret())
                .setSubject(email)
                .setHeaderParam("typ", type)
                .claim("role", role)
                .setIssuedAt(new Date())
                .setExpiration(new Date(System.currentTimeMillis() + exp * 1000))
                .compact();
    }
}