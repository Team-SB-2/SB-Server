package com.example.sbserver.domain.subject.service;

import com.example.sbserver.domain.subject.domain.Subject;
import com.example.sbserver.domain.subject.domain.repository.SubjectRepository;
import com.example.sbserver.domain.subject.exception.SubjectExistsException;
import com.example.sbserver.domain.subject.presentation.dto.request.CreateSubjectRequest;
import com.example.sbserver.domain.user.domain.User;
import com.example.sbserver.domain.user.facade.UserFacade;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import javax.transaction.Transactional;

@RequiredArgsConstructor
@Service
public class CreateSubjectService {

    private final SubjectRepository subjectRepository;
    private final UserFacade userFacade;

    @Transactional
    public void execute(CreateSubjectRequest request) {
        User user = userFacade.getCurrentUser();

        if (subjectRepository.existsByTitle(request.getTitle())) {
            Subject subject = subjectRepository.findByTitle(request.getTitle());
            if (subject.getIsViewable()) {
                throw SubjectExistsException.EXCEPTION;
            }
            subject.updateIsViewable(true);
        } else {
            subjectRepository.save(
                    Subject.builder()
                            .title(request.getTitle())
                            .emoji(request.getEmoji())
                            .user(user)
                            .build()
            );
        }
    }
}
