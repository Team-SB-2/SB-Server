package com.example.sbserver.domain.record.domain.repository;

import com.example.sbserver.domain.record.domain.Record;
import com.example.sbserver.domain.record.domain.repository.vo.FocusVo;
import com.example.sbserver.domain.record.domain.repository.vo.QRecordVo;
import com.example.sbserver.domain.record.domain.repository.vo.QFocusVo;
import com.example.sbserver.domain.record.domain.repository.vo.RecordVo;
import com.example.sbserver.domain.user.domain.QUser;
import com.example.sbserver.domain.user.domain.User;
import com.querydsl.jpa.impl.JPAQuery;
import com.querydsl.jpa.impl.JPAQueryFactory;
import lombok.RequiredArgsConstructor;

import javax.management.Query;
import java.time.LocalDate;
import java.time.LocalDateTime;
import java.time.LocalTime;
import java.time.YearMonth;
import java.util.List;
import java.util.Optional;

import static com.example.sbserver.domain.subject.domain.QSubject.subject;
import static com.example.sbserver.domain.record.domain.QRecord.record;

@RequiredArgsConstructor
public class CustomRecordRepositoryImpl implements CustomRecordRepository {
    private final JPAQueryFactory jpaQueryFactory;

    @Override
    public List<RecordVo> findByFinishedDateAndUser(LocalDate date, User user) {
        LocalDateTime startDate = date.atTime(5, 0, 0);
        LocalDateTime endDate = startDate.plusDays(1);

        return jpaQueryFactory.select(new QRecordVo(record, subject))
                .from(record)
                .innerJoin(subject).on(record.subject.eq(subject))
                .innerJoin(QUser.user).on(record.user.eq(QUser.user))
                .where(record.finishedTime.between(startDate, endDate.minusNanos(1))
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

    @Override
    public Integer findFocusedTimeByLocalDateAndUser(LocalDateTime localDateTime, User user) {
        return jpaQueryFactory.select(record.total.sum())
                .from(record)
                .where(record.user.eq(user)
                        .and(record.finishedTime.between(localDateTime, localDateTime.minusDays(30))))
                .fetchOne();
    }

    @Override
    public Record findLastRecordByUser(User user) {
        return jpaQueryFactory.select(record)
                .from(record)
                .where(record.user.eq(user))
                .orderBy(record.finishedTime.desc())
                .fetchFirst();
    }

    @Override
    public List<Integer> findRecordedDaysByYearMonthAndUser(YearMonth yearMonth, User user) {
       return jpaQueryFactory.selectDistinct(record.finishedTime.dayOfMonth())
               .from(record)
               .where(record.finishedTime.between(yearMonth.atDay(1).atStartOfDay(),
                       yearMonth.atEndOfMonth().atTime(LocalTime.MAX)).and(record.user.eq(user)))
               .orderBy(record.id.asc())
               .fetch();
    }
}