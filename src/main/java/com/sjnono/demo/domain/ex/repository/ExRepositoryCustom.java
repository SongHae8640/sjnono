package com.sjnono.demo.domain.ex.repository;

import com.sjnono.demo.domain.ex.entity.Example;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;

public interface ExRepositoryCustom {

    Example findByIdJoinStock(Long id);

    Page<Example> search(Pageable pageable);
}
