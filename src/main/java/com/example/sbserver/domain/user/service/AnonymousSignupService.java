package com.example.sbserver.domain.user.service;

import com.example.sbserver.domain.auth.dto.response.TokenResponse;
import com.example.sbserver.domain.user.domain.Role;
import com.example.sbserver.domain.user.domain.User;
import com.example.sbserver.domain.user.domain.repository.UserRepository;
import com.example.sbserver.domain.user.facade.UserFacade;
import com.example.sbserver.global.security.jwt.JwtTokenProvider;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

@RequiredArgsConstructor
@Service
public class AnonymousSignupService {
    private final UserRepository userRepository;
    private final UserFacade userFacade;
    private final JwtTokenProvider jwtTokenProvider;
    private static int USER_COUNT_NUMBER;
    private static final String USERNAME = "똑똑이";

    @Transactional
    public TokenResponse execute() {

        try {
            userFacade.getCurrentUser();
        } catch (Exception e) {
            USER_COUNT_NUMBER += 1;
            User user = User.builder()
                    .email(USERNAME + USER_COUNT_NUMBER)
                    .build();

            userRepository.save(user);

            return jwtTokenProvider.getToken(user.getEmail(), Role.USER.toString());
        }
        return null;
    }
}
