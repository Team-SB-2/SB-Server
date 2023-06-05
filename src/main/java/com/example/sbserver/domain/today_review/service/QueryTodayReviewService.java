package com.example.sbserver.domain.today_review.service;

import com.example.sbserver.domain.today_review.domain.TodayReview;
import com.example.sbserver.domain.today_review.domain.repository.TodayReviewRepository;
import com.example.sbserver.domain.today_review.exception.TodayReviewNotFoundException;
import com.example.sbserver.domain.today_review.presentation.dto.response.QueryTodayReviewResponse;
import com.example.sbserver.domain.user.domain.User;
import com.example.sbserver.domain.user.facade.UserFacade;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.time.LocalDate;

@RequiredArgsConstructor
@Service
public class QueryTodayReviewService {
    private final TodayReviewRepository todayReviewRepository;
    private final UserFacade userFacade;

    @Transactional
    public QueryTodayReviewResponse execute(LocalDate date) {
        User user = userFacade.getCurrentUser();
        saveIfTodayReviewNotExists(user, date);

        TodayReview review = todayReviewRepository.findByUserAndDate(user, date)
                .orElseThrow(() -> TodayReviewNotFoundException.EXCEPTION);

        return new QueryTodayReviewResponse(review.getId(), review.getContent());
    }

    private void saveIfTodayReviewNotExists(User user, LocalDate date) {
        if (!todayReviewRepository.existsByUserAndDate(user, date))
            todayReviewRepository.save(
                    new TodayReview(user, date)
            );
    }
}
