package com.example.sbserver.domain.today_review.presentation;

import com.example.sbserver.domain.today_review.presentation.dto.request.UpdateTodayReviewRequest;
import com.example.sbserver.domain.today_review.presentation.dto.response.QueryTodayReviewResponse;
import com.example.sbserver.domain.today_review.service.QueryTodayReviewService;
import com.example.sbserver.domain.today_review.service.UpdateTodayReviewService;
import lombok.RequiredArgsConstructor;
import org.springframework.format.annotation.DateTimeFormat;
import org.springframework.web.bind.annotation.*;

import java.time.LocalDate;

@RequiredArgsConstructor
@RestController
@RequestMapping("/record")
public class TodayReviewController {
    private final UpdateTodayReviewService updateTodayReviewService;
    private final QueryTodayReviewService queryTodayReviewService;

    @PatchMapping("/today-review/{review-id}")
    public void updateTodayReview(@PathVariable("review-id") Long id, UpdateTodayReviewRequest request) {
        updateTodayReviewService.execute(id, request);
    }

    @GetMapping("/today-review")
    public QueryTodayReviewResponse execute(@RequestParam @DateTimeFormat(pattern = "yyyy-MM-dd") LocalDate date) {
        return queryTodayReviewService.execute(date);
    }
}
