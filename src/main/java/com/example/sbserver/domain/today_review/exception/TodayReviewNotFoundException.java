package com.example.sbserver.domain.today_review.exception;

import com.example.sbserver.global.error.BusinessException;
import com.example.sbserver.global.error.ErrorCode;

public class TodayReviewNotFoundException extends BusinessException {
    public static final BusinessException EXCEPTION =
            new TodayReviewNotFoundException();

    private TodayReviewNotFoundException() {
        super(ErrorCode.TODAY_REVIEW_NOT_FOUND);
    }
}
