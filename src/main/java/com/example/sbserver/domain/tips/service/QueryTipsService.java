package com.example.sbserver.domain.tips.service;

import com.example.sbserver.domain.tips.domain.Tips;
import com.example.sbserver.domain.tips.domain.repository.TipsRepository;
import com.example.sbserver.domain.tips.presentation.dto.response.QueryTipsResponse;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;

@RequiredArgsConstructor
@Service
public class QueryTipsService {
    private final TipsRepository tipsRepository;

    @Transactional(readOnly = true)
    public List<QueryTipsResponse> execute() {
        List<Tips> tips = tipsRepository.findAll();

        return tips.stream().map(
                tip -> QueryTipsResponse.builder()
                        .tipId(tip.getId())
                        .title(tip.getTitle())
                        .content(tip.getContent())
                        .build()
        ).toList();
    }
}
