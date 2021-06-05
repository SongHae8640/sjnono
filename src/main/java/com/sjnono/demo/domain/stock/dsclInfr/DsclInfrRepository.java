package com.sjnono.demo.domain.stock.dsclInfr;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface DsclInfrRepository extends JpaRepository<DsclInfr, Long> {
}
