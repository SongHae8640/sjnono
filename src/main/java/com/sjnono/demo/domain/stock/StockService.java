package com.sjnono.demo.domain.stock;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.Optional;

@Service
public class StockService {

    @Autowired
    StockRepository stockRepository;


    public Stock getStockDetail(String standardCode) {

        Stock stock = stockRepository.findByStandardCode(standardCode);


        return stock;
    }

    public Stock saveStock(Stock stock){
        //


        return null;
    }
}
