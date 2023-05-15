package com.example.sbserver.domain.record.service;

import com.example.sbserver.domain.record.domain.repository.RecordRepository;
import com.example.sbserver.domain.record.domain.repository.vo.CalendarTimeVo;
import com.example.sbserver.domain.record.presentation.dto.response.QueryCalendarTimeResponse;
import com.example.sbserver.domain.user.domain.User;
import com.example.sbserver.domain.user.facade.UserFacade;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.time.LocalDate;

@RequiredArgsConstructor
@Service
public class QueryCalendarTimeService {
    private final RecordRepository recordRepository;
    private final UserFacade userFacade;

    public QueryCalendarTimeResponse execute(LocalDate date) {
        User user = userFacade.getCurrentUser();
        CalendarTimeVo calendarTimeVo = recordRepository.findCalendarFocusedTimeByLocalDateAndUser(date, user);

        return new QueryCalendarTimeResponse(calendarTimeVo.getTotalFocusedTime(), calendarTimeVo.getMaxFocusedTime());
    }
}
