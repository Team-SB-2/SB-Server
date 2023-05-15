package com.example.sbserver.domain.record.service;

import com.example.sbserver.domain.record.domain.repository.RecordRepository;
import com.example.sbserver.domain.record.presentation.dto.response.QueryRecordedDaysResponse;
import com.example.sbserver.domain.user.domain.User;
import com.example.sbserver.domain.user.facade.UserFacade;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.time.YearMonth;
import java.util.List;

@RequiredArgsConstructor
@Service
public class QueryRecordedDaysService {
    private final RecordRepository recordRepository;
    private final UserFacade userFacade;

    public QueryRecordedDaysResponse execute(String yearMonthStr) {
        User user = userFacade.getCurrentUser();
        YearMonth yearMonth = YearMonth.parse(yearMonthStr);
        List<Integer> recordedDays = recordRepository.findRecordedDaysByYearMonthAndUser(yearMonth, user);

        return new QueryRecordedDaysResponse(yearMonth, recordedDays);
    }
}
