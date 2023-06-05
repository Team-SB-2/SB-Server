package com.example.sbserver.domain.record.exception;

import com.example.sbserver.global.error.BusinessException;
import com.example.sbserver.global.error.ErrorCode;

public class RecordNotFoundException extends BusinessException {
    public static final BusinessException EXCEPTION =
            new RecordNotFoundException();

    private RecordNotFoundException() {
        super(ErrorCode.RECORD_NOT_FOUND);
    }
}
