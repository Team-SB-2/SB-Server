package com.example.sbserver.domain.user.presentation;

import com.example.sbserver.domain.auth.dto.response.AnonymousUserResponse;
import com.example.sbserver.domain.auth.dto.response.TokenResponse;
import com.example.sbserver.domain.user.presentation.dto.request.LoginRequest;
import com.example.sbserver.domain.user.presentation.dto.request.SignUpRequest;
import com.example.sbserver.domain.user.presentation.dto.request.UpdateUserInfoRequest;
import com.example.sbserver.domain.user.presentation.dto.response.QueryUserInfoResponse;
import com.example.sbserver.domain.user.service.*;
import lombok.RequiredArgsConstructor;
import org.springframework.web.bind.annotation.*;

import javax.validation.Valid;

@RequiredArgsConstructor
@RestController
@RequestMapping("/users")
public class UserController {
    private final SignUpService signUpService;
    private final LoginService loginService;
    private final AnonymousSignupService anonymousSignupService;
    private final TokenRefreshService tokenRefreshService;
    private final QueryMyInfoService queryMyInfoService;
    private final UpdateUserInfoService updateUserInfoService;
    private final LogoutService logoutService;
    private final WithdrawalService withdrawalService;

    @PostMapping
    public TokenResponse signUp(@RequestBody @Valid SignUpRequest request) {
        return signUpService.execute(request);
    }

    @PostMapping("/anonymous")
    public AnonymousUserResponse anonymousSignUp() {
        return anonymousSignupService.execute();
    }

    @PostMapping("/token")
    public TokenResponse login(@RequestBody @Valid LoginRequest request) {
        return loginService.execute(request);
    }

    @PatchMapping("/token")
    public TokenResponse reIssue(@RequestHeader("X-Refresh-Token") String refreshToken) {
        return tokenRefreshService.execute(refreshToken);
    }

    @PatchMapping
    public void updateInfo(@RequestBody @Valid UpdateUserInfoRequest updateUserInfoRequest) {
        updateUserInfoService.execute(updateUserInfoRequest);
    }

    @GetMapping
    public QueryUserInfoResponse execute() {
        return queryMyInfoService.execute();
    }

    @DeleteMapping("/logout")
    public void logout() {
        logoutService.execute();
    }

    @DeleteMapping
    public void withdrawal() {
        withdrawalService.execute();
    }
}
