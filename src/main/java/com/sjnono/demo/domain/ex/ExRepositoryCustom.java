package com.sjnono.demo.domain.ex;

import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;

public interface ExRepositoryCustom {

    Example findByIdJoinStock(Long id);

    Page<Example> search(Pageable pageable);
}
