package com.example.sbserver.domain.today_review.domain.repository;

import com.example.sbserver.domain.today_review.domain.TodayReview;
import com.example.sbserver.domain.user.domain.User;
import org.springframework.data.repository.CrudRepository;

import java.time.LocalDate;
import java.util.Optional;

public interface TodayReviewRepository extends CrudRepository<TodayReview, Long> {

    boolean existsByUserAndDate(User user, LocalDate date);
    Optional<TodayReview> findByUserAndDate(User user, LocalDate date);

}
