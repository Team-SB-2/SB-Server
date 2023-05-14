package com.example.sbserver.domain.record.domain.repository;

import com.example.sbserver.domain.record.domain.Record;
import com.example.sbserver.domain.record.domain.repository.vo.FocusVo;
import com.example.sbserver.domain.record.domain.repository.vo.RecordVo;
import com.example.sbserver.domain.user.domain.User;
import com.querydsl.jpa.impl.JPAQuery;

import java.lang.reflect.Array;
import java.time.LocalDate;
import java.time.LocalDateTime;
import java.time.YearMonth;
import java.util.List;
import java.util.Optional;

public interface CustomRecordRepository {
    List<RecordVo> findByFinishedDateAndUser(LocalDate date, User user);
    List<FocusVo> findByYearMonthAndUser(YearMonth yearMonth, User user);

    Integer findFocusedTimeByLocalDateAndUser(LocalDateTime localDateTime, User user);

    Record findLastRecordByUser(User user);

    List<Integer> findRecordedDaysByYearMonthAndUser(YearMonth yearMonth, User user);
}
