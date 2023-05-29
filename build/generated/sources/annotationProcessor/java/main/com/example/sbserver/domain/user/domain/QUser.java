package com.example.sbserver.domain.user.domain;

import static com.querydsl.core.types.PathMetadataFactory.*;

import com.querydsl.core.types.dsl.*;

import com.querydsl.core.types.PathMetadata;
import javax.annotation.processing.Generated;
import com.querydsl.core.types.Path;
import com.querydsl.core.types.dsl.PathInits;


/**
 * QUser is a Querydsl query type for User
 */
@Generated("com.querydsl.codegen.DefaultEntitySerializer")
public class QUser extends EntityPathBase<User> {

    private static final long serialVersionUID = 1129226065L;

    public static final QUser user = new QUser("user");

    public final com.example.sbserver.global.entity.QBaseTimeEntity _super = new com.example.sbserver.global.entity.QBaseTimeEntity(this);

    public final NumberPath<Integer> age = createNumber("age", Integer.class);

    //inherited
    public final DateTimePath<java.time.LocalDateTime> createdAt = _super.createdAt;

    public final StringPath email = createString("email");

    public final NumberPath<Long> id = createNumber("id", Long.class);

    public final BooleanPath isMarketingAgreed = createBoolean("isMarketingAgreed");

    public final StringPath name = createString("name");

    public final StringPath password = createString("password");

    public final ListPath<com.example.sbserver.domain.record.domain.Record, com.example.sbserver.domain.record.domain.QRecord> recordList = this.<com.example.sbserver.domain.record.domain.Record, com.example.sbserver.domain.record.domain.QRecord>createList("recordList", com.example.sbserver.domain.record.domain.Record.class, com.example.sbserver.domain.record.domain.QRecord.class, PathInits.DIRECT2);

    public final EnumPath<Role> role = createEnum("role", Role.class);

    public final EnumPath<Sex> sex = createEnum("sex", Sex.class);

    public final ListPath<com.example.sbserver.domain.subject.domain.Subject, com.example.sbserver.domain.subject.domain.QSubject> subjectList = this.<com.example.sbserver.domain.subject.domain.Subject, com.example.sbserver.domain.subject.domain.QSubject>createList("subjectList", com.example.sbserver.domain.subject.domain.Subject.class, com.example.sbserver.domain.subject.domain.QSubject.class, PathInits.DIRECT2);

    public QUser(String variable) {
        super(User.class, forVariable(variable));
    }

    public QUser(Path<? extends User> path) {
        super(path.getType(), path.getMetadata());
    }

    public QUser(PathMetadata metadata) {
        super(User.class, metadata);
    }

}

