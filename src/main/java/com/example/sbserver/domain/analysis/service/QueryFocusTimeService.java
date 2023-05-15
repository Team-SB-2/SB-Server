package com.example.sbserver.domain.analysis.service;

import com.example.sbserver.domain.analysis.presentation.dto.response.FocusResponse;
import com.example.sbserver.domain.analysis.presentation.dto.response.QueryFocusTimeListResponse;
import com.example.sbserver.domain.record.domain.repository.RecordRepository;
import com.example.sbserver.domain.record.domain.repository.vo.FocusVo;
import com.example.sbserver.domain.user.domain.User;
import com.example.sbserver.domain.user.facade.UserFacade;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.time.YearMonth;
import java.util.Comparator;
import java.util.List;
import java.util.stream.Collectors;

@RequiredArgsConstructor
@Service
public class QueryFocusTimeService {
    private final UserFacade userFacade;
    private final RecordRepository recordRepository;

    public QueryFocusTimeListResponse execute(YearMonth yearMonth) {
        User user = userFacade.getCurrentUser();
        List<FocusVo> focusVoList = recordRepository.findByYearMonthAndUser(yearMonth, user);
        int totalTime = getTotalTime(focusVoList);

        List<FocusResponse> focusResponses = focusVoList.stream()
                .map(FocusResponse::of)
                .sorted(Comparator.comparingInt(FocusResponse::getSum).reversed())
                .collect(Collectors.toList());

        return QueryFocusTimeListResponse.builder()
                .yearMonth(yearMonth)
                .totalTime(totalTime)
                .focusResponses(getListWithEtc(focusResponses).stream()
                        .map(it -> it.updateFocusRatio(getTimeRatio(it.getSum(), totalTime)))
                        .collect(Collectors.toList()))
                .build();
    }

    private List<FocusResponse> getListWithEtc(List<FocusResponse> focusResponses) {
        if (focusResponses.size() > 3) {
            int etcSum = focusResponses.stream()
                    .skip(3)
                    .mapToInt(FocusResponse::getSum)
                    .sum();

            FocusResponse focusResponse = FocusResponse.builder()
                    .title("기타")
                    .emoji("")
                    .sum(etcSum)
                    .build();

            focusResponses = focusResponses.stream()
                    .limit(3)
                    .collect(Collectors.toList());
            focusResponses.add(2, focusResponse);
        }
        return focusResponses;
    }

    private int getTotalTime(List<FocusVo> focusVoList) {
        return focusVoList.stream().mapToInt(FocusVo::getSum).sum();
    }

    private Integer getTimeRatio(int sum, int total) {
        return sum > 0 ? (int) ((float) sum / (float) total * 100) : 0;
    }
}