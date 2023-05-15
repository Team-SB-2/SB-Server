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
        List<FocusResponse> focusResponses = focusVoList
                .stream()
                .map(FocusResponse::of)
                .collect(Collectors.toList());

        return QueryFocusTimeListResponse.builder()
                .yearMonth(yearMonth)
                .totalTime(getTotalTime(focusVoList))
                .focusResponses(getListWithEtc(focusResponses))
                .build();
        }

    private List<FocusResponse> getListWithEtc(List<FocusResponse> focusResponses) {
        if (focusResponses.size() > 3) {
            int etcSum = 0;
            for (int i = 3; i < focusResponses.size(); i++) {
                etcSum += focusResponses.get(i).getSum();
            }
            FocusResponse focusResponse = FocusResponse.builder()
                    .title("기타")
                    .emoji("")
                    .sum(etcSum)
                    .build();

            focusResponses.add(3, focusResponse);
            focusResponses.subList(3, focusResponses.size()).clear();
        }
        return focusResponses;
    }

    private int getTotalTime(List<FocusVo> focusVoList) {
        return focusVoList.stream().mapToInt(FocusVo::getSum).sum();
    }
}