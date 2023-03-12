package com.example.sbserver.domain.record.domain.repository;

import com.example.sbserver.domain.record.domain.Record;
import org.springframework.data.repository.CrudRepository;

public interface RecordRepository extends CrudRepository<Record, Long>, CustomRecordRepository {
}
