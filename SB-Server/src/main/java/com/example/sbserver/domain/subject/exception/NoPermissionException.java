package com.example.sbserver.domain.subject.exception;

import com.example.sbserver.global.error.BusinessException;
import com.example.sbserver.global.error.ErrorCode;

public class NoPermissionException extends BusinessException {
    public static final BusinessException EXCEPTION =
            new NoPermissionException();

    private NoPermissionException() {
        super(ErrorCode.NO_PERMISSION_TO_ACCESS);
    }
}
