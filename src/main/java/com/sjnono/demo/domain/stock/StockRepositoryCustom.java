package com.sjnono.demo.domain.stock;

import java.util.List;

public interface StockRepositoryCustom {

    Stock findByStandardCode(String standardCode);
    Stock findByKoreanStockName(String shrIpt);
    List<Stock> findAllByShortCodeStartsWithOrKoreanStockNameStartsWith(String shortCode, String koreanStockName);
}
