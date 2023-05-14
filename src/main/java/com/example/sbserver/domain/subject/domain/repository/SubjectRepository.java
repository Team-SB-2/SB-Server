package com.example.sbserver.domain.subject.domain.repository;

import com.example.sbserver.domain.subject.domain.Subject;
import com.example.sbserver.domain.user.domain.User;
import org.springframework.data.repository.CrudRepository;

public interface SubjectRepository extends CrudRepository<Subject, Long>, CustomSubjectRepository {

    boolean existsByTitleAndUser(String title, User user);

    Subject findByTitle(String title);
}
