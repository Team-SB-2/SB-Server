package com.example.sbserver.domain.user.service;

import com.example.sbserver.domain.auth.dto.response.TokenResponse;
import com.example.sbserver.domain.auth.dto.response.UserTokenResponse;
import com.example.sbserver.domain.user.domain.User;
import com.example.sbserver.domain.user.domain.repository.UserRepository;
import com.example.sbserver.domain.user.exception.UserNotFoundException;
import com.example.sbserver.domain.user.facade.UserFacade;
import com.example.sbserver.global.security.jwt.JwtTokenProvider;
import com.example.sbserver.global.util.password.PasswordUtil;
import lombok.RequiredArgsConstructor;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.UUID;

@RequiredArgsConstructor
@Service
public class AnonymousSignupService {
    private final UserRepository userRepository;
    private final JwtTokenProvider jwtTokenProvider;
    private final PasswordEncoder passwordEncoder;
    private final UserFacade userFacade;
    private final PasswordUtil passwordUtil;
    private static int userCountNumber;
    private static final String BASE_USERNAME = "똑똑이";

    @Transactional
    public UserTokenResponse execute() {
        User user = getUserOrCreateNewUser();
        TokenResponse tokenResponse = jwtTokenProvider.getToken(user.getEmail(), user.getRole().toString());
        return new UserTokenResponse(tokenResponse, user.getEmail(), user.getPassword());
    }

    private User getUserOrCreateNewUser() {
        try {
            return userFacade.getCurrentUser();
        } catch (Exception e) {
            String newUsername = generateNewUsername();
            String password = passwordUtil.generateRandomPassword();
            User newUser = createUser(newUsername, password);
            return userRepository.save(newUser);
        }
    }

    private String generateNewUsername() {
        userCountNumber++;
        return BASE_USERNAME + userCountNumber;
    }

    private User createUser(String username, String password) {
        return User.builder()
                .email(generateRandomString())
                .password(passwordEncoder.encode(password))
                .name(username)
                .build();
    }

    private String generateRandomString() {
        String uuid = UUID.randomUUID().toString().replace("-", "");
        return uuid.substring(0, 12);
    }
}