package com.example.sbserver.domain.record.domain.repository;

import com.example.sbserver.domain.record.domain.Record;
import com.example.sbserver.domain.user.domain.User;
import org.springframework.data.repository.CrudRepository;

import java.time.LocalDateTime;
import java.util.Optional;

public interface RecordRepository extends CrudRepository<Record, Long>, CustomRecordRepository {
    boolean existsByUser(User user);
}
