package com.example.sbserver.domain.subject.domain.repository;

import com.example.sbserver.domain.subject.domain.Subject;
import com.example.sbserver.domain.subject.domain.repository.vo.QSubjectVo;
import com.example.sbserver.domain.subject.domain.repository.vo.SubjectVo;
import com.example.sbserver.domain.user.domain.QUser;
import com.example.sbserver.domain.user.domain.User;
import com.querydsl.jpa.impl.JPAQueryFactory;
import lombok.RequiredArgsConstructor;

import java.util.List;

import static com.example.sbserver.domain.subject.domain.QSubject.subject;


@RequiredArgsConstructor
public class CustomSubjectRepositoryImpl implements CustomSubjectRepository {
    private final JPAQueryFactory jpaQueryFactory;

    @Override
    public List<SubjectVo> findAllByUser(User user) {
        return jpaQueryFactory
                .select(new QSubjectVo(subject, QUser.user))
                .from(subject)
                .innerJoin(subject.user, QUser.user)
                .where(QUser.user.eq(user))
                .stream().toList();
    }
}
