package com.example.sbserver.domain.notice.service;

import com.example.sbserver.domain.notice.domain.repository.NoticeRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

@RequiredArgsConstructor
@Service
public class DeleteNoticeService {
    private final NoticeRepository noticeRepository;

    @Transactional
    public void execute(Long id) {
        noticeRepository.deleteById(id);
    }
}
