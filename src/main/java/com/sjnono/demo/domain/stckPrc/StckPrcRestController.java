package com.sjnono.demo.domain.stckPrc;

import com.sjnono.demo.domain.stock.Stock;
import com.sjnono.demo.domain.stock.StockService;
import lombok.AllArgsConstructor;
import lombok.Data;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.net.URI;
import java.util.List;
import java.util.stream.Collectors;

@RestController
@RequestMapping("/api/stckPrc")
public class StckPrcRestController {

    @Autowired
    StckPrcService stckPrcService;

    @GetMapping("/{standardCode}")
    public ResponseEntity getStckPrc(@PathVariable String standardCode ){
        List<StckPrc> stckPrcList = stckPrcService.findAllByStandardCode(standardCode);

        List<StckPrcRestController.stckPrcDto> stockPrcDtoList = stckPrcList.stream()
                .map(stckPrc -> new StckPrcRestController.stckPrcDto(
                        stckPrc.getPrice()
                        ,stckPrc.getPriceDate()
                        ,stckPrc.getStock().getStandardCode()
                        ,stckPrc.getStock().getShortCode()
                        ,stckPrc.getStock().getKoreanStockName() ))
                .collect(Collectors.toList());

        return ResponseEntity.created(URI.create("")).body(stockPrcDtoList);
    }

    @Data
    @AllArgsConstructor
    static class stckPrcDto{
        int price;
        String PriceDate;
        String standardCode;
        String shortCode;
        String koreanStockName;
    }
}
