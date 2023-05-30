package com.example.sbserver.domain.user.service;

import com.example.sbserver.domain.auth.dto.response.TokenResponse;
import com.example.sbserver.domain.user.domain.Role;
import com.example.sbserver.domain.user.domain.User;
import com.example.sbserver.domain.user.domain.repository.UserRepository;
import com.example.sbserver.domain.user.exception.EmailExistsException;
import com.example.sbserver.domain.user.facade.UserFacade;
import com.example.sbserver.domain.user.presentation.dto.request.SignUpRequest;
import com.example.sbserver.global.security.jwt.JwtTokenProvider;
import lombok.RequiredArgsConstructor;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Service;

import javax.transaction.Transactional;

@RequiredArgsConstructor
@Service
public class SignUpService {
    private final UserRepository userRepository;
    private final PasswordEncoder passwordEncoder;
    private final UserFacade userFacade;
    private final JwtTokenProvider jwtTokenProvider;

    @Transactional
    public TokenResponse execute(SignUpRequest request) {
        User user = userFacade.getCurrentUser();
        if(userRepository.findByEmail(request.getEmail()).isPresent()) {
            throw EmailExistsException.EXCEPTION;
        }
        user.registerAsMember(
                user.getEmail(), request.getPassword(), request.getName(),
                request.getAge(), request.getSex(), request.getIsMarketingAgreed()
        );

        return jwtTokenProvider.getToken(request.getEmail(), user.getRole().toString());
    }
}
