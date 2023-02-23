package com.example.sbserver.domain.user.service;

import com.example.sbserver.domain.auth.dto.response.TokenResponse;
import com.example.sbserver.domain.user.domain.User;
import com.example.sbserver.domain.user.domain.repository.UserRepository;
import com.example.sbserver.domain.user.exception.PasswordMismatchException;
import com.example.sbserver.domain.user.exception.UserNotFoundException;
import com.example.sbserver.domain.user.presentation.dto.request.LoginRequest;
import com.example.sbserver.global.security.jwt.JwtTokenProvider;
import lombok.RequiredArgsConstructor;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Service;

import javax.transaction.Transactional;

@RequiredArgsConstructor
@Service
public class LoginService {
    private final UserRepository userRepository;
    private final PasswordEncoder passwordEncoder;
    private final JwtTokenProvider jwtTokenProvider;

    @Transactional
    public TokenResponse execute(LoginRequest request) {

        User user = userRepository.findByEmail(request.getEmail())
                .orElseThrow(() -> UserNotFoundException.EXCEPTION);
        if(!passwordEncoder.matches(user.getPassword(), request.getPassword())) {
            throw PasswordMismatchException.EXCEPTION;
        }

        return jwtTokenProvider.getToken(user.getEmail(), user.getRole().toString());
    }
}
