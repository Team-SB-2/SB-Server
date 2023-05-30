package com.example.sbserver.domain.user.service;

import com.example.sbserver.domain.auth.dto.response.AnonymousUserResponse;
import com.example.sbserver.domain.auth.dto.response.TokenResponse;
import com.example.sbserver.domain.user.domain.Role;
import com.example.sbserver.domain.user.domain.User;
import com.example.sbserver.domain.user.domain.repository.UserRepository;
import com.example.sbserver.global.security.jwt.JwtTokenProvider;
import com.example.sbserver.global.util.password.PasswordUtil;
import lombok.RequiredArgsConstructor;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

@RequiredArgsConstructor
@Service
public class AnonymousSignupService {
    private final UserRepository userRepository;
    private final JwtTokenProvider jwtTokenProvider;
    private final PasswordEncoder passwordEncoder;
    private final PasswordUtil passwordUtil;
    private static int USER_COUNT_NUMBER;
    private static final String USERNAME = "똑똑이";

    @Transactional
    public AnonymousUserResponse execute() {
        USER_COUNT_NUMBER += 1;
        String newUsername = USERNAME + USER_COUNT_NUMBER;
        String password = passwordUtil.generateRandomPassword();
        User user = User.builder()
                .email(newUsername)
                .password(passwordEncoder.encode(password))
                .name(newUsername)
                .build();

        userRepository.save(user);

        TokenResponse token = jwtTokenProvider.getToken(user.getEmail(), Role.USER.toString());
        return new AnonymousUserResponse(token, user.getEmail(), password);
    }
}