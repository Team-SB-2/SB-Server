package com.example.sbserver.domain.notice.service;

import com.example.sbserver.domain.notice.domain.Notice;
import com.example.sbserver.domain.notice.domain.repository.NoticeRepository;
import com.example.sbserver.domain.notice.dto.request.UpdateNoticeRequest;
import com.example.sbserver.domain.notice.exception.NoticeNotFoundException;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

@RequiredArgsConstructor
@Service
public class UpdateNoticeService {
    private final NoticeRepository noticeRepository;

    @Transactional
    public void execute(Long id, UpdateNoticeRequest request) {
        Notice notice = noticeRepository.findById(id)
                .orElseThrow(() -> NoticeNotFoundException.EXCEPTION);

        notice.update(request.getTitle(), request.getContent());
    }
}
