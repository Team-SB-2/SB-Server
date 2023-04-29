package com.example.sbserver.domain.analysis.service;

import com.example.sbserver.domain.analysis.presentation.dto.response.QueryFocusGraphResponse;
import com.example.sbserver.domain.record.domain.repository.RecordRepository;
import com.example.sbserver.domain.user.domain.User;
import com.example.sbserver.domain.user.facade.UserFacade;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.time.LocalDateTime;

@RequiredArgsConstructor
@Service
public class QueryFocusGraphService {
    private final RecordRepository recordRepository;
    private final UserFacade userFacade;

    @Transactional
    public QueryFocusGraphResponse execute() {
        LocalDateTime today = LocalDateTime.now();
        User user = userFacade.getCurrentUser();

        Integer thisFocusedTime = recordRepository.findFocusedTimeByLocalDateAndUser(today, user);
        Integer lastFocusedTime = recordRepository.findFocusedTimeByLocalDateAndUser(today.minusDays(30), user);

        boolean isThisFocusedTimeBig = thisFocusedTime > lastFocusedTime;

        Integer growthPercent =  isThisFocusedTimeBig?
                (int) ((float)thisFocusedTime / (float)lastFocusedTime * 100) : 0;

        Integer increasedTime = isThisFocusedTimeBig?
                (thisFocusedTime - lastFocusedTime) / 1000  : 0;

        return QueryFocusGraphResponse.builder()
                .thisMonth(today.getMonth())
                .lastMonth(today.minusMonths(1).getMonth())
                .growthPercent(growthPercent)
                .increasedTime(increasedTime)
                .build();
    }
}
