package com.example.sbserver.domain.tips.presentation;

import com.example.sbserver.domain.tips.presentation.dto.response.QueryTipsResponse;
import com.example.sbserver.domain.tips.service.QueryTipsService;
import lombok.RequiredArgsConstructor;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RequiredArgsConstructor
@RestController
@RequestMapping("/tips")
public class TipsController {
    private final QueryTipsService queryTipsService;

    @GetMapping
    public List<QueryTipsResponse> queryNoticeList() {
        return queryTipsService.execute();
    }
}
