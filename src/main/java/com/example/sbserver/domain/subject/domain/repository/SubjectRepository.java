package com.example.sbserver.domain.subject.domain.repository;

import com.example.sbserver.domain.subject.domain.Subject;
import com.example.sbserver.domain.user.domain.User;
import org.springframework.data.repository.CrudRepository;

import java.util.List;

public interface SubjectRepository extends CrudRepository<Subject, Long>, CustomSubjectRepository {

    boolean existsByTitleAndUser(String title, User user);

    Subject findByTitleAndUser(String title, User user);

    Integer countByUserAndIsViewableTrue(User user);
}
