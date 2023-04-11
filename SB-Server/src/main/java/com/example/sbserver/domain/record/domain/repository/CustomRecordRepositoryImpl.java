package com.example.sbserver.domain.record.domain.repository;

import com.example.sbserver.domain.record.domain.Record;
import com.example.sbserver.domain.record.domain.repository.vo.FocusVo;
import com.example.sbserver.domain.record.domain.repository.vo.QRecordVo;
import com.example.sbserver.domain.record.domain.repository.vo.QFocusVo;
import com.example.sbserver.domain.record.domain.repository.vo.RecordVo;
import com.example.sbserver.domain.user.domain.QUser;
import com.example.sbserver.domain.user.domain.User;
import com.querydsl.jpa.impl.JPAQueryFactory;
import lombok.RequiredArgsConstructor;

import java.time.LocalDate;
import java.time.LocalDateTime;
import java.time.LocalTime;
import java.time.YearMonth;
import java.util.List;

import static com.example.sbserver.domain.subject.domain.QSubject.subject;
import static com.example.sbserver.domain.record.domain.QRecord.record;

@RequiredArgsConstructor
public class CustomRecordRepositoryImpl implements CustomRecordRepository {
    private final JPAQueryFactory jpaQueryFactory;

    @Override
    public List<RecordVo> findByFinishedDateAndUser(LocalDate date, User user) {
        return jpaQueryFactory.select(new QRecordVo(record, subject))
                .from(record)
                .innerJoin(record.subject, subject)
                .innerJoin(record.user, QUser.user)
                .where(record.finishedTime.between(date.atStartOfDay(), date.plusDays(1).atStartOfDay().minusNanos(1))
                        .and(record.user.eq(user)))
                .fetch();
    }

    @Override
    public List<FocusVo> findByYearMonthAndUser(YearMonth yearMonth, User user) {
        return jpaQueryFactory.select(new QFocusVo(subject.title, subject.emoji, record.total.sum()))
                .from(record)
                .innerJoin(record.subject, subject)
                .groupBy(subject.id)
                .where(record.user.eq(user), record.finishedTime.between(yearMonth.atDay(1).atStartOfDay(),
                        yearMonth.atEndOfMonth().atTime(LocalTime.MAX)))
                .fetch();
    }
}