package com.example.sbserver.domain.faq.domain.repository;

import com.example.sbserver.domain.faq.domain.Faq;
import org.springframework.data.repository.CrudRepository;

import java.util.List;

public interface FaqRepository extends CrudRepository<Faq, Long> {
    List<Faq> findAll();
}
