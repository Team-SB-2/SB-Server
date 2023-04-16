package com.example.sbserver.domain.tips.domain;

import static com.querydsl.core.types.PathMetadataFactory.*;

import com.querydsl.core.types.dsl.*;

import com.querydsl.core.types.PathMetadata;
import javax.annotation.processing.Generated;
import com.querydsl.core.types.Path;
import com.querydsl.core.types.dsl.PathInits;


/**
 * QTips is a Querydsl query type for Tips
 */
@Generated("com.querydsl.codegen.DefaultEntitySerializer")
public class QTips extends EntityPathBase<Tips> {

    private static final long serialVersionUID = -2110475605L;

    private static final PathInits INITS = PathInits.DIRECT2;

    public static final QTips tips = new QTips("tips");

    public final com.example.sbserver.global.entity.QBaseTimeEntity _super = new com.example.sbserver.global.entity.QBaseTimeEntity(this);

    public final StringPath content = createString("content");

    //inherited
    public final DateTimePath<java.time.LocalDateTime> createdAt = _super.createdAt;

    public final NumberPath<Long> id = createNumber("id", Long.class);

    public final StringPath title = createString("title");

    public final com.example.sbserver.domain.user.domain.QUser user;

    public QTips(String variable) {
        this(Tips.class, forVariable(variable), INITS);
    }

    public QTips(Path<? extends Tips> path) {
        this(path.getType(), path.getMetadata(), PathInits.getFor(path.getMetadata(), INITS));
    }

    public QTips(PathMetadata metadata) {
        this(metadata, PathInits.getFor(metadata, INITS));
    }

    public QTips(PathMetadata metadata, PathInits inits) {
        this(Tips.class, metadata, inits);
    }

    public QTips(Class<? extends Tips> type, PathMetadata metadata, PathInits inits) {
        super(type, metadata, inits);
        this.user = inits.isInitialized("user") ? new com.example.sbserver.domain.user.domain.QUser(forProperty("user")) : null;
    }

}

