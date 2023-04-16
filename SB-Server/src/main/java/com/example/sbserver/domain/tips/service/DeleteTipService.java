package com.example.sbserver.domain.tips.service;

import com.example.sbserver.domain.tips.domain.repository.TipsRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

@RequiredArgsConstructor
@Service
public class DeleteTipService {
    private final TipsRepository tipsRepository;

    @Transactional
    public void execute(Long id) {
        tipsRepository.deleteById(id);
    }
}
