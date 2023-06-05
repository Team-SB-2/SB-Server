package com.example.sbserver.domain.today_review.service;

import com.example.sbserver.domain.today_review.domain.TodayReview;
import com.example.sbserver.domain.today_review.domain.repository.TodayReviewRepository;
import com.example.sbserver.domain.today_review.exception.TodayReviewNotFoundException;
import com.example.sbserver.domain.today_review.presentation.dto.request.UpdateTodayReviewRequest;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

@RequiredArgsConstructor
@Service
public class UpdateTodayReviewService {
    private final TodayReviewRepository todayReviewRepository;

    @Transactional
    public void execute(Long reviewId, UpdateTodayReviewRequest request) {
        TodayReview review = todayReviewRepository.findById(reviewId)
                .orElseThrow(() -> TodayReviewNotFoundException.EXCEPTION);

        review.updateContent(request.getContent());
    }
}
