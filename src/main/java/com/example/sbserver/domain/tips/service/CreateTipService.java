package com.example.sbserver.domain.tips.service;

import com.example.sbserver.domain.tips.domain.Tips;
import com.example.sbserver.domain.tips.domain.repository.TipsRepository;
import com.example.sbserver.domain.tips.dto.request.CreateTipRequest;
import com.example.sbserver.domain.user.domain.User;
import com.example.sbserver.domain.user.facade.UserFacade;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

@RequiredArgsConstructor
@Service
public class CreateTipService {
    private final TipsRepository tipsRepository;
    private final UserFacade userFacade;

    @Transactional
    public void execute(CreateTipRequest request) {
        User user = userFacade.getCurrentUser();
        tipsRepository.save(
                Tips.builder()
                        .title(request.getTitle())
                        .content(request.getContent())
                        .user(user)
                        .build()
        );
    }
}
