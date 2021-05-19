package com.sjnono.demo.domain.ex;


import com.querydsl.jpa.impl.JPAQueryFactory;
import lombok.RequiredArgsConstructor;

@RequiredArgsConstructor
public class ExRepositoryCustomImpl implements ExRepositoryCustom{

    private final JPAQueryFactory queryFactory;



}
