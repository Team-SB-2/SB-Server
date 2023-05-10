package com.example.sbserver.domain.faq.service;

import com.example.sbserver.domain.faq.domain.Faq;
import com.example.sbserver.domain.faq.domain.repository.FaqRepository;
import com.example.sbserver.domain.faq.presentation.dto.response.QueryFaqResponse;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;

@RequiredArgsConstructor
@Service
public class QueryFaqListService {
    private final FaqRepository faqRepository;

    @Transactional(readOnly = true)
    public List<QueryFaqResponse> execute() {
        List<Faq> faqs = faqRepository.findAll();

        return faqs.stream().map(
                faq -> QueryFaqResponse.builder()
                        .tipId(faq.getId())
                        .title(faq.getTitle())
                        .content(faq.getContent())
                        .build()
        ).toList();
    }
}
