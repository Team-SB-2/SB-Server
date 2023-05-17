package com.example.sbserver.domain.subject.exception;

import com.example.sbserver.global.error.BusinessException;
import com.example.sbserver.global.error.ErrorCode;

public class SubjectLimitExceededException extends BusinessException {
    public static final BusinessException EXCEPTION =
            new SubjectLimitExceededException();

    private SubjectLimitExceededException() {
        super(ErrorCode.SUBJECT_LIMIT_EXCEEDED);
    }
}
