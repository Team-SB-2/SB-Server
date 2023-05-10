package com.example.sbserver.domain.faq.presentation;

import com.example.sbserver.domain.faq.presentation.dto.response.QueryFaqResponse;
import com.example.sbserver.domain.faq.service.QueryFaqListService;
import lombok.RequiredArgsConstructor;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RequiredArgsConstructor
@RestController
@RequestMapping("/faq")
public class FaqController {
    private final QueryFaqListService queryFaqListService;

    @GetMapping
    public List<QueryFaqResponse> queryNoticeList() {
        return queryFaqListService.execute();
    }
}
