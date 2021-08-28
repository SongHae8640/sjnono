package com.sjnono.demo.domain.stckPrc;

import com.sjnono.demo.domain.stock.Stock;
import com.sjnono.demo.domain.stock.StockRepositoryCustom;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface StckPrcRepository extends JpaRepository<StckPrc, Integer> , StckPrcRepositoryCustom {


}
