package com.example.sbserver.domain.user.exception;

import com.example.sbserver.global.error.BusinessException;
import com.example.sbserver.global.error.ErrorCode;

public class EmailExistsException extends BusinessException {
    public static final BusinessException EXCEPTION
            = new EmailExistsException();

    private EmailExistsException() {
        super(ErrorCode.EMAIL_EXIST);
    }
}
