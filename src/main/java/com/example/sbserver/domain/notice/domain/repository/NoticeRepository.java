package com.example.sbserver.domain.notice.domain.repository;

import com.example.sbserver.domain.notice.domain.Notice;
import org.springframework.data.repository.CrudRepository;

public interface NoticeRepository extends CrudRepository<Notice, Long> {
}
