package com.sjnono.demo.domain.stock;

import com.querydsl.jpa.impl.JPAQueryFactory;
import lombok.RequiredArgsConstructor;
import java.util.List;

import static  com.sjnono.demo.domain.stock.QStock.stock;

@RequiredArgsConstructor
public class StockRepositoryCustomImpl implements StockRepositoryCustom{

    private final JPAQueryFactory queryFactory;

    @Override
    public Stock findByStandardCode(String standardCode) {
        return queryFactory.selectFrom(stock)
                .where(stock.shortCode.eq(standardCode))
                .fetchOne();
    }
    @Override
    public Stock findByKoreanStockName(String koreanStockName) {
        return null;
    }
    @Override
    public List<Stock> findAllByShortCodeStartsWithOrKoreanStockNameStartsWith(String shortCode, String koreanStockName) {
        return queryFactory.selectFrom(stock)
                .where(stock.shortCode.contains(shortCode)
                        .or(stock.koreanStockName.contains(koreanStockName)))
                .fetch();
    }


}
