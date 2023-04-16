package com.example.sbserver.domain.record.domain.repository.vo;

import com.querydsl.core.types.dsl.*;

import com.querydsl.core.types.ConstructorExpression;
import javax.annotation.processing.Generated;

/**
 * com.example.sbserver.domain.record.domain.repository.vo.QFocusVo is a Querydsl Projection type for FocusVo
 */
@Generated("com.querydsl.codegen.DefaultProjectionSerializer")
public class QFocusVo extends ConstructorExpression<FocusVo> {

    private static final long serialVersionUID = -637613356L;

    public QFocusVo(com.querydsl.core.types.Expression<String> title, com.querydsl.core.types.Expression<String> emoji, com.querydsl.core.types.Expression<Integer> sum) {
        super(FocusVo.class, new Class<?>[]{String.class, String.class, int.class}, title, emoji, sum);
    }

}

