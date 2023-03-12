package com.example.sbserver.domain.subject.domain.repository;

import com.example.sbserver.domain.subject.domain.Subject;
import org.springframework.data.repository.CrudRepository;

import java.util.List;

public interface SubjectRepository extends CrudRepository<Subject, Long>, CustomSubjectRepository {

    boolean existsByTitle(String title);

    Subject findByTitle(String title);
}
