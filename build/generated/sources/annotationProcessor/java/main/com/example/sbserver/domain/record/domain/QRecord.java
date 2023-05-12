package com.example.sbserver.domain.record.domain;

import static com.querydsl.core.types.PathMetadataFactory.*;

import com.querydsl.core.types.dsl.*;

import com.querydsl.core.types.PathMetadata;
import javax.annotation.processing.Generated;
import com.querydsl.core.types.Path;
import com.querydsl.core.types.dsl.PathInits;


/**
 * QRecord is a Querydsl query type for Record
 */
@Generated("com.querydsl.codegen.DefaultEntitySerializer")
public class QRecord extends EntityPathBase<Record> {

    private static final long serialVersionUID = -1272489827L;

    private static final PathInits INITS = PathInits.DIRECT2;

    public static final QRecord record = new QRecord("record");

    public final DateTimePath<java.time.LocalDateTime> finishedTime = createDateTime("finishedTime", java.time.LocalDateTime.class);

    public final NumberPath<Long> id = createNumber("id", Long.class);

    public final BooleanPath isRecord = createBoolean("isRecord");

    public final StringPath memo = createString("memo");

    public final DateTimePath<java.time.LocalDateTime> startedTime = createDateTime("startedTime", java.time.LocalDateTime.class);

    public final com.example.sbserver.domain.subject.domain.QSubject subject;

    public final NumberPath<Integer> total = createNumber("total", Integer.class);

    public final com.example.sbserver.domain.user.domain.QUser user;

    public QRecord(String variable) {
        this(Record.class, forVariable(variable), INITS);
    }

    public QRecord(Path<? extends Record> path) {
        this(path.getType(), path.getMetadata(), PathInits.getFor(path.getMetadata(), INITS));
    }

    public QRecord(PathMetadata metadata) {
        this(metadata, PathInits.getFor(metadata, INITS));
    }

    public QRecord(PathMetadata metadata, PathInits inits) {
        this(Record.class, metadata, inits);
    }

    public QRecord(Class<? extends Record> type, PathMetadata metadata, PathInits inits) {
        super(type, metadata, inits);
        this.subject = inits.isInitialized("subject") ? new com.example.sbserver.domain.subject.domain.QSubject(forProperty("subject"), inits.get("subject")) : null;
        this.user = inits.isInitialized("user") ? new com.example.sbserver.domain.user.domain.QUser(forProperty("user")) : null;
    }

}

