package com.sjnono.demo.domain.stock;

import org.springframework.hateoas.EntityModel;
import org.springframework.hateoas.Link;

public class StockResource extends EntityModel<Stock> {

    public StockResource(Stock stock, Link... links) {
        super(stock, links);
    }
}
