package com.sjnono.demo.domain.stock;

import com.sjnono.demo.domain.ex.controller.ExRestController;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.RequiredArgsConstructor;
import org.springframework.data.domain.PageImpl;
import org.springframework.hateoas.EntityModel;
import org.springframework.hateoas.PagedModel;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.net.URI;
import java.util.List;
import java.util.stream.Collectors;

import static org.springframework.hateoas.server.mvc.WebMvcLinkBuilder.linkTo;
import static org.springframework.hateoas.server.mvc.WebMvcLinkBuilder.methodOn;

@RestController
@RequestMapping("/api/stock")
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

        List<StockDto> stockDtoList = stockList.stream().map(stock -> new StockDto(stock.getStandardCode(),stock.getKoreanStockName()))
                .collect(Collectors.toList());

        return ResponseEntity.created(URI.create("")).body(stockList);
    }


    @PutMapping("/category")
    public ResponseEntity modifyStockCategory() {
        List<Stock> stocks = stockService.findAllStock();

        stockService.updateStockCategories(stocks);

        return null;
    }


    @Data
    @AllArgsConstructor
    static class StockDto {
        private String standardCode;
        private String koreanStockName;
    }

}
