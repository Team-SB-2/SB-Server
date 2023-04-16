package com.example.sbserver.domain.faq.service;

import com.example.sbserver.domain.faq.domain.Faq;
import com.example.sbserver.domain.faq.domain.repository.FaqRepository;
import com.example.sbserver.domain.notice.dto.request.CreateNoticeRequest;
import com.example.sbserver.domain.user.domain.User;
import com.example.sbserver.domain.user.facade.UserFacade;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

@RequiredArgsConstructor
@Service
public class CreateFaqService {
    private final FaqRepository faqRepository;
    private final UserFacade userFacade;

    @Transactional
    public void execute(CreateNoticeRequest request) {
        User user = userFacade.getCurrentUser();

        faqRepository.save(
                Faq.builder()
                        .title(request.getTitle())
                        .content(request.getContent())
                        .user(user)
                        .build()
        );
    }
}
