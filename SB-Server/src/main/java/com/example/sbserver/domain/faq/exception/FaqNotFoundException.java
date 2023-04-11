package com.example.sbserver.domain.faq.exception;

import com.example.sbserver.global.error.BusinessException;
import com.example.sbserver.global.error.ErrorCode;

public class FaqNotFoundException extends BusinessException {
    public static final BusinessException EXCEPTION =
            new FaqNotFoundException();

    private FaqNotFoundException() {
        super(ErrorCode.FAQ_NOT_FOUND);
    }
}
