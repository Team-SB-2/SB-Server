package com.example.sbserver.domain.tips.domain.repository;

import com.example.sbserver.domain.tips.domain.Tips;
import org.springframework.data.repository.CrudRepository;

import java.util.List;

public interface TipsRepository extends CrudRepository<Tips, Long> {
    List<Tips> findAll();
}
