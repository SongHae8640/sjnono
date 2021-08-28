package com.sjnono.demo.domain.stckPrc;

import com.sjnono.demo.domain.stock.Stock;
import com.sjnono.demo.domain.stock.StockRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class StckPrcService {

    @Autowired
    StckPrcRepository stckPrcRepository;

    public List<StckPrc> findAllByStandardCode(String standardCode) {

        List<StckPrc> stckPrcList = stckPrcRepository.findAllByStandardCode(standardCode);


        return stckPrcList;
    }
}
