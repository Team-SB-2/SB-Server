package com.example.sbserver.domain.tips.service;

import com.example.sbserver.domain.tips.domain.Tips;
import com.example.sbserver.domain.tips.domain.repository.TipsRepository;
import com.example.sbserver.domain.tips.dto.request.UpdateTipRequest;
import com.example.sbserver.domain.tips.exception.TipNotFoundException;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

@RequiredArgsConstructor
@Service
public class UpdateTipService {
    private final TipsRepository tipsRepository;


    @Transactional
    public void execute(Long id, UpdateTipRequest request) {
        Tips tip = tipsRepository.findById(id)
                .orElseThrow(() -> TipNotFoundException.EXCEPTION);

        tip.update(request.getTitle(), request.getContent());

    }
}
