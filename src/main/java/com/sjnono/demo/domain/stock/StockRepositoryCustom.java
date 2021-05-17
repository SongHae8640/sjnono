package com.sjnono.demo.domain.stock;

public interface StockRepositoryCustom {

    Stock findByStandardCode(String standardCode);
}
