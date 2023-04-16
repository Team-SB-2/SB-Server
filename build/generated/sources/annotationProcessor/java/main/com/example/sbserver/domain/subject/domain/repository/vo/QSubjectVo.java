package com.example.sbserver.domain.subject.domain.repository.vo;

import com.querydsl.core.types.dsl.*;

import com.querydsl.core.types.ConstructorExpression;
import javax.annotation.processing.Generated;

/**
 * com.example.sbserver.domain.subject.domain.repository.vo.QSubjectVo is a Querydsl Projection type for SubjectVo
 */
@Generated("com.querydsl.codegen.DefaultProjectionSerializer")
public class QSubjectVo extends ConstructorExpression<SubjectVo> {

    private static final long serialVersionUID = 1627858635L;

    public QSubjectVo(com.querydsl.core.types.Expression<Long> subjectId, com.querydsl.core.types.Expression<String> title, com.querydsl.core.types.Expression<String> emoji, com.querydsl.core.types.Expression<Long> userId, com.querydsl.core.types.Expression<Integer> todayRecord) {
        super(SubjectVo.class, new Class<?>[]{long.class, String.class, String.class, long.class, int.class}, subjectId, title, emoji, userId, todayRecord);
    }

}

