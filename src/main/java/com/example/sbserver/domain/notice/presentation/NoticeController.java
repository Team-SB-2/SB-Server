package com.example.sbserver.domain.notice.presentation;

import com.example.sbserver.domain.notice.presentation.dto.response.QueryNoticeResponse;
import com.example.sbserver.domain.notice.service.QueryNoticeListService;
import lombok.RequiredArgsConstructor;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RequiredArgsConstructor
@RestController
@RequestMapping("/notice")
public class NoticeController {
    private final QueryNoticeListService queryNoticeListService;

    @GetMapping
    public List<QueryNoticeResponse> queryNoticeList() {
        return queryNoticeListService.execute();
    }
}
