package com.example.sbserver.domain.subject.exception;

import com.example.sbserver.global.error.BusinessException;
import com.example.sbserver.global.error.ErrorCode;

public class SubjectExistsException extends BusinessException {
    public static final BusinessException EXCEPTION =
            new SubjectExistsException();

    private SubjectExistsException() {
        super(ErrorCode.SUBJECT_EXISTS);
    }
}
