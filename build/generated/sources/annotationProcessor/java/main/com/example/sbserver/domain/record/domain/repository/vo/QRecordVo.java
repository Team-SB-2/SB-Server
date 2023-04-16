package com.example.sbserver.domain.record.domain.repository.vo;

import com.querydsl.core.types.dsl.*;

import com.querydsl.core.types.ConstructorExpression;
import javax.annotation.processing.Generated;

/**
 * com.example.sbserver.domain.record.domain.repository.vo.QRecordVo is a Querydsl Projection type for RecordVo
 */
@Generated("com.querydsl.codegen.DefaultProjectionSerializer")
public class QRecordVo extends ConstructorExpression<RecordVo> {

    private static final long serialVersionUID = 857049639L;

    public QRecordVo(com.querydsl.core.types.Expression<? extends com.example.sbserver.domain.record.domain.Record> record, com.querydsl.core.types.Expression<? extends com.example.sbserver.domain.subject.domain.Subject> subject) {
        super(RecordVo.class, new Class<?>[]{com.example.sbserver.domain.record.domain.Record.class, com.example.sbserver.domain.subject.domain.Subject.class}, record, subject);
    }

}

