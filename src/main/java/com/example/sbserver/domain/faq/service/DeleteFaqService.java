package com.example.sbserver.domain.faq.service;

import com.example.sbserver.domain.faq.domain.repository.FaqRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

@RequiredArgsConstructor
@Service
public class DeleteFaqService {
    private final FaqRepository faqRepository;

    @Transactional
    public void execute(Long id) {
        faqRepository.deleteById(id);
    }
}
