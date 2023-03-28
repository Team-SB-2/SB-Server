package com.example.sbserver.domain.notice.service;

import com.example.sbserver.domain.notice.domain.Notice;
import com.example.sbserver.domain.notice.domain.repository.NoticeRepository;
import com.example.sbserver.domain.notice.dto.request.CreateNoticeRequest;
import com.example.sbserver.domain.user.domain.User;
import com.example.sbserver.domain.user.facade.UserFacade;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

@RequiredArgsConstructor
@Service
public class CreateNoticeService {
    private final NoticeRepository noticeRepository;
    private final UserFacade userFacade;

    @Transactional
    public void execute(CreateNoticeRequest request) {
        User user = userFacade.getCurrentUser();

        noticeRepository.save(
                Notice.builder()
                        .title(request.getTitle())
                        .content(request.getContent())
                        .user(user)
                        .build()
        );
    }
}
