package com.sjnono.demo.domain.ex;


import com.querydsl.jpa.impl.JPAQueryFactory;
import com.sjnono.demo.domain.ex.QExample;
import com.sjnono.demo.domain.stock.QStock;
import lombok.RequiredArgsConstructor;


import static com.sjnono.demo.domain.ex.QExample.*;
import static com.sjnono.demo.domain.stock.QStock.*;

@RequiredArgsConstructor
public class ExRepositoryCustomImpl implements ExRepositoryCustom{

    private final JPAQueryFactory queryFactory;


    @Override
    public Example findByIdJoinStock(Long id) {

        
        return queryFactory.selectFrom(example)
                .innerJoin(example.stock, stock)
                .fetchJoin()
                .where(example.id.eq(id))
                .fetchOne()
                ;
    }
}
