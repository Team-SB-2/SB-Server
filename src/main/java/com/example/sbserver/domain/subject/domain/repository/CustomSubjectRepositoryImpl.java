package com.example.sbserver.domain.subject.domain.repository;

import com.example.sbserver.domain.subject.domain.repository.vo.QSubjectVo;
import com.example.sbserver.domain.subject.domain.repository.vo.SubjectVo;
import com.example.sbserver.domain.user.domain.QUser;
import com.example.sbserver.domain.user.domain.User;
import com.querydsl.jpa.impl.JPAQueryFactory;
import lombok.RequiredArgsConstructor;

import java.time.LocalDateTime;
import java.util.List;

import static com.example.sbserver.domain.subject.domain.QSubject.subject;
import static com.example.sbserver.domain.record.domain.QRecord.record;


@RequiredArgsConstructor
public class CustomSubjectRepositoryImpl implements CustomSubjectRepository {
    private final JPAQueryFactory jpaQueryFactory;

    @Override
    public List<SubjectVo> findAllByUserAndDateTime(User user, LocalDateTime dateTime) {
        return jpaQueryFactory
                .select(new QSubjectVo(subject.id, subject.title, subject.emoji, subject.user.id, record.total.sum()))
                .from(subject)
                .leftJoin(record).on(subject.eq(record.subject).and(record.finishedTime.eq(dateTime)))
                .leftJoin(subject.user, QUser.user)
                .groupBy(subject)
                .where(subject.user.eq(user))
                .fetch();
    }
}