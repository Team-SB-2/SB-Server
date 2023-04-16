package com.example.sbserver.domain.subject.service;

import com.example.sbserver.domain.subject.domain.Subject;
import com.example.sbserver.domain.subject.domain.repository.SubjectRepository;
import com.example.sbserver.domain.subject.exception.NoPermissionException;
import com.example.sbserver.domain.subject.exception.SubjectNotFoundException;
import com.example.sbserver.domain.user.domain.User;
import com.example.sbserver.domain.user.facade.UserFacade;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import javax.transaction.Transactional;

@RequiredArgsConstructor
@Service
public class DeleteSubjectService {
    private final SubjectRepository subjectRepository;
    private final UserFacade userFacade;

    @Transactional
    public void execute(Long id) {
        Subject subject = subjectRepository.findById(id)
                .orElseThrow(() -> SubjectNotFoundException.EXCEPTION);

        User user = userFacade.getCurrentUser();

        if(!subject.getUser().equals(user)) {
            throw NoPermissionException.EXCEPTION;
        }

        subject.updateIsViewable(false);
    }
}
