package com.sjnono.demo.domain.stock;

import lombok.RequiredArgsConstructor;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.net.URI;
import java.util.List;

@RestController
@RequestMapping("/stock")
@RequiredArgsConstructor
public class StockRestController {

    private final StockService stockService;


//    @GetMapping("/{id}")
//    public ResponseEntity getStockDetail(@PathVariable String standardCode}{
//
//        Stock stock = stockService.getStockDetail(standardCode);
//
//        return ResponseEntity.created(URI.create("")).body(stock);
//    }

    @GetMapping("/{shrIpt}")
    public ResponseEntity getStockList(@PathVariable String shrIpt){

        List<Stock> stockList = stockService.getStockList(shrIpt);

        return ResponseEntity.created(URI.create("")).body(stockList);
    }

}
