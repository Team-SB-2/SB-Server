package com.example.sbserver.domain.subject.presentation;

import com.example.sbserver.domain.subject.presentation.dto.request.CreateSubjectRequest;
import com.example.sbserver.domain.subject.presentation.dto.response.QuerySubjectListResponse;
import com.example.sbserver.domain.subject.service.CreateSubjectService;
import com.example.sbserver.domain.subject.service.DeleteSubjectService;
import com.example.sbserver.domain.subject.service.QueryMySubjectsService;
import lombok.RequiredArgsConstructor;
import org.springframework.web.bind.annotation.*;

import javax.validation.Valid;

@RequiredArgsConstructor
@RestController
@RequestMapping("/subject")
public class SubjectController {
    private final CreateSubjectService createSubjectService;
    private final DeleteSubjectService deleteSubjectService;
    private final QueryMySubjectsService queryMySubjectsService;

    @PostMapping
    public void createSubject(@RequestBody @Valid CreateSubjectRequest request) {
        createSubjectService.execute(request);
    }

    @DeleteMapping("/{subject-id}")
    public void deleteSubject(@PathVariable("subject-id") Long id) {
        deleteSubjectService.execute(id);
    }

    @GetMapping
    public QuerySubjectListResponse querySubjects() {
        return queryMySubjectsService.execute();
    }
}
