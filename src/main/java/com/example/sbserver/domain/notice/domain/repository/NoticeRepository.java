package com.example.sbserver.domain.notice.domain.repository;

import com.example.sbserver.domain.notice.domain.Notice;
import org.springframework.data.repository.CrudRepository;

import java.util.List;

public interface NoticeRepository extends CrudRepository<Notice, Long> {
    List<Notice> findAll();
}
