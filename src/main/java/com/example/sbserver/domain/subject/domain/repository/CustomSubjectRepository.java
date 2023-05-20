package com.example.sbserver.domain.subject.domain.repository;


import com.example.sbserver.domain.subject.domain.repository.vo.SubjectVo;
import com.example.sbserver.domain.user.domain.User;

import java.time.LocalDate;
import java.util.List;

public interface CustomSubjectRepository {
    List<SubjectVo> findAllByUserAndDate(User user, LocalDate date);
}
