package com.sjnono.demo.domain.stock;

import org.modelmapper.ModelMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.net.URI;

@RestController
@RequestMapping("/stock")
public class StockRestController {

    @Autowired
    StockService stockService;

    @Autowired
    ModelMapper modelMapper;

//    @GetMapping("/{id}")
//    public ResponseEntity getStockDetail(@PathVariable String standardCode}{
//
//        Stock stock = stockService.getStockDetail(standardCode);
//
//        return ResponseEntity.created(URI.create("")).body(stock);
//    }


}
