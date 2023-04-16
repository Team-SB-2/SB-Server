package com.example.sbserver.domain.tips.exception;

import com.example.sbserver.global.error.BusinessException;
import com.example.sbserver.global.error.ErrorCode;

public class TipNotFoundException extends BusinessException {
    public static final BusinessException EXCEPTION =
            new TipNotFoundException();

    private TipNotFoundException() {
        super(ErrorCode.TIP_NOT_FOUND);
    }
}
