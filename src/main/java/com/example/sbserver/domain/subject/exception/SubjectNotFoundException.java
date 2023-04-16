package com.example.sbserver.domain.subject.exception;

import com.example.sbserver.global.error.BusinessException;
import com.example.sbserver.global.error.ErrorCode;

public class SubjectNotFoundException extends BusinessException {
    public static final BusinessException EXCEPTION =
            new SubjectNotFoundException();

    private SubjectNotFoundException() {
        super(ErrorCode.SUBJECT_NOT_FOUND);
    }
}
