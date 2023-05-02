package com.example.sbserver.domain.subject.service;

import com.example.sbserver.domain.subject.domain.repository.SubjectRepository;
import com.example.sbserver.domain.subject.domain.repository.vo.SubjectVo;
import com.example.sbserver.domain.subject.presentation.dto.response.QuerySubjectListResponse;
import com.example.sbserver.domain.subject.presentation.dto.response.QuerySubjectResponse;
import com.example.sbserver.domain.user.domain.User;
import com.example.sbserver.domain.user.facade.UserFacade;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.time.LocalDateTime;
import java.util.List;
import java.util.stream.Collectors;

@RequiredArgsConstructor
@Service
public class QueryMySubjectsService {
    private final SubjectRepository subjectRepository;
    private final UserFacade userFacade;

    @Transactional(readOnly = true)
    public QuerySubjectListResponse execute() {
        User user = userFacade.getCurrentUser();
        LocalDateTime now = LocalDateTime.now();
        List<SubjectVo> subjects = subjectRepository.findAllByUserAndDateTime(user, now);

        List<QuerySubjectResponse> subjectResponses = subjects.stream().map(
                subject -> QuerySubjectResponse.builder()
                        .id(subject.getSubjectId())
                        .title(subject.getTitle())
                        .emoji(subject.getEmoji())
                        .userId(subject.getUserId())
                        .todayRecord(subject.getTodayRecord())
                        .build()
        ).toList();

        int totalTime = subjectResponses.stream()
                .mapToInt(QuerySubjectResponse::getTodayRecord)
                .sum();

        return QuerySubjectListResponse.builder()
                .subjectList(subjectResponses)
                .totalTime(totalTime)
                .build();
    }
}

