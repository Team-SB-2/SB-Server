package com.example.sbserver.domain.subject.service;

import com.example.sbserver.domain.subject.domain.Subject;
import com.example.sbserver.domain.subject.domain.repository.SubjectRepository;
import com.example.sbserver.domain.subject.exception.SubjectExistsException;
import com.example.sbserver.domain.subject.exception.SubjectLimitExceededException;
import com.example.sbserver.domain.subject.presentation.dto.request.CreateSubjectRequest;
import com.example.sbserver.domain.user.domain.User;
import com.example.sbserver.domain.user.facade.UserFacade;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import javax.transaction.Transactional;

@RequiredArgsConstructor
@Service
public class CreateSubjectService {

    private static final int SUBJECT_LIMIT = 9;
    private final SubjectRepository subjectRepository;
    private final UserFacade userFacade;

    @Transactional
    public void execute(CreateSubjectRequest request) {
        User user = userFacade.getCurrentUser();

        if (subjectRepository.countByUserAndIsViewableTrue(user) > SUBJECT_LIMIT) {
            throw SubjectLimitExceededException.EXCEPTION;
        }

        if (subjectRepository.existsByTitleAndUser(request.getTitle(), user)) {
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
