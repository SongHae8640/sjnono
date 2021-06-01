package com.sjnono.demo.domain.stock;

import lombok.RequiredArgsConstructor;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.Optional;

@Service
@RequiredArgsConstructor
@Transactional(readOnly = true)
public class StockService {

    private final StockRepository stockRepository;


    public Stock getStockDetail(String standardCode) {

        Stock stock = stockRepository.findByStandardCode(standardCode);


        return stock;
    }

    public Stock saveStock(Stock stock){
        //


        return null;
    }
}
