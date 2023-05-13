package com.example.sbserver.domain.notice.service;

import com.example.sbserver.domain.notice.domain.Notice;
import com.example.sbserver.domain.notice.domain.repository.NoticeRepository;
import com.example.sbserver.domain.notice.presentation.dto.response.QueryNoticeResponse;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;

@RequiredArgsConstructor
@Service
public class QueryNoticeListService {
    private final NoticeRepository noticeRepository;

    @Transactional(readOnly = true)
    public List<QueryNoticeResponse> execute() {
        List<Notice> notices = noticeRepository.findAll();

        return notices.stream().map(
                notice -> QueryNoticeResponse.builder()
                        .title(notice.getTitle())
                        .content(notice.getContent())
                        .createdAt(notice.getCreatedAt())
                        .build()
        ).toList();
    }
}
