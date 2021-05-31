package com.sjnono.demo.domain.fnncSttm;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface FnncSttmRepository extends JpaRepository<FnncSttm, Long> {
}
