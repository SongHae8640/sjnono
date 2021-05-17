package com.sjnono.demo.domain.stock;

import com.querydsl.jpa.impl.JPAQueryFactory;
import lombok.RequiredArgsConstructor;

@RequiredArgsConstructor
public class StockRepositoryCustomImpl implements StockRepositoryCustom{

    private final JPAQueryFactory queryFactory;

    @Override
    public Stock findByStandardCode(String standardCode) {
        return null;//queryFactory.selectFrom();
    }
}
