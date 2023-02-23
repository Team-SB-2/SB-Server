package com.example.sbserver.domain.user.service;

import com.example.sbserver.domain.user.domain.User;
import com.example.sbserver.domain.user.facade.UserFacade;
import com.example.sbserver.domain.user.presentation.dto.response.QueryUserInfoResponse;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

@RequiredArgsConstructor
@Service
public class QueryMyInfoService {
    private final UserFacade userFacade;

    public QueryUserInfoResponse execute() {

        User user = userFacade.getCurrentUser();

        return QueryUserInfoResponse.of(user);
    }
}
