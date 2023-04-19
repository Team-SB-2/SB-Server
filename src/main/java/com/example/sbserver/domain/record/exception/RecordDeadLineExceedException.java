package com.example.sbserver.domain.record.exception;

import com.example.sbserver.global.error.BusinessException;
import com.example.sbserver.global.error.ErrorCode;

public class RecordDeadLineExceedException extends BusinessException {
    public static final BusinessException EXCEPTION =
            new RecordDeadLineExceedException();

    private RecordDeadLineExceedException() {
        super(ErrorCode.RECORD_DEADLINE_EXCEED);
    }
}
