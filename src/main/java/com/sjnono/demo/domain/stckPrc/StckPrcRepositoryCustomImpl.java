package com.sjnono.demo.domain.stckPrc;

import com.querydsl.jpa.impl.JPAQueryFactory;
import lombok.RequiredArgsConstructor;

import java.util.List;

import static  com.sjnono.demo.domain.stock.QStock.stock;
import static  com.sjnono.demo.domain.stckPrc.QStckPrc.stckPrc;


@RequiredArgsConstructor
public class StckPrcRepositoryCustomImpl implements StckPrcRepositoryCustom {

    private final JPAQueryFactory queryFactory;

    @Override
    public List<StckPrc> findAllByStandardCode(String standardCode) {
        return queryFactory.selectFrom(stckPrc)
                .innerJoin( stckPrc.stock , stock)
                .where(stckPrc.stock.standardCode.eq(standardCode))
                .fetch();

    }
}
