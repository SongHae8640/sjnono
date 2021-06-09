package com.sjnono.demo.domain.ex.repository;


import com.querydsl.core.QueryResults;
import com.querydsl.jpa.impl.JPAQueryFactory;
import com.sjnono.demo.domain.ex.entity.Example;
import lombok.RequiredArgsConstructor;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageImpl;
import org.springframework.data.domain.Pageable;


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

    @Override
    public Page<Example> search(Pageable pageable) {
        QueryResults<Example> exampleQueryResults = queryFactory.selectFrom(example)
                .innerJoin(example.stock, stock)
                .fetchJoin()
                .offset(pageable.getOffset())
                .limit(pageable.getPageSize())
                .fetchResults();
        return new PageImpl<>(exampleQueryResults.getResults(), pageable,exampleQueryResults.getTotal());
    }
}
