package com.sjnono.demo.domain.stock;

import java.util.List;

public interface StockRepositoryCustom {

    Stock findByStandardCode(String standardCode);

}
