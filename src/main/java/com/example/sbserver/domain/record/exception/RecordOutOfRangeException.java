package com.example.sbserver.domain.record.exception;

import com.example.sbserver.global.error.BusinessException;
import com.example.sbserver.global.error.ErrorCode;

public class RecordOutOfRangeException extends BusinessException {
    public static final BusinessException EXCEPTION =
            new RecordOutOfRangeException();

    private RecordOutOfRangeException() {
        super(ErrorCode.RECORD_OUT_OF_RANGE);
    }
}
