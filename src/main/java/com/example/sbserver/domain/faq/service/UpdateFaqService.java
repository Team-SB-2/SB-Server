package com.example.sbserver.domain.faq.service;

import com.example.sbserver.domain.faq.domain.Faq;
import com.example.sbserver.domain.faq.domain.repository.FaqRepository;
import com.example.sbserver.domain.faq.exception.FaqNotFoundException;
import com.example.sbserver.domain.notice.dto.request.UpdateNoticeRequest;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

@RequiredArgsConstructor
@Service
public class UpdateFaqService {
    private final FaqRepository faqRepository;

    @Transactional
    public void execute(Long id, UpdateNoticeRequest request) {
        Faq faq = faqRepository.findById(id)
                .orElseThrow(() -> FaqNotFoundException.EXCEPTION);

        faq.update(request.getTitle(), request.getContent());
    }
}
