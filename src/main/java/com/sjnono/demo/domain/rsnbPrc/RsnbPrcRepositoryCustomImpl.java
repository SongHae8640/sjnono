package com.sjnono.demo.domain.rsnbPrc;

import com.querydsl.core.types.dsl.BooleanExpression;
import com.querydsl.jpa.impl.JPAQueryFactory;
import com.sjnono.demo.domain.rsnbPrc.QRsnbPr;
import com.sjnono.demo.domain.stock.QStock;
import lombok.RequiredArgsConstructor;
import org.thymeleaf.util.StringUtils;

import java.util.List;

import static com.sjnono.demo.domain.rsnbPrc.QRsnbPr.rsnbPr;

@RequiredArgsConstructor
public class RsnbPrcRepositoryCustomImpl implements RsnbPrcRepositoryCustom{

    private final JPAQueryFactory queryFactory;


    @Override
    public List<RsnbPr> findByConditions(RsnPrcRestController.RscnPrcInquiryRequestDto requestDto) {

        return queryFactory
                .selectFrom(rsnbPr)
                .innerJoin(rsnbPr.stock, QStock.stock)
                .fetchJoin()
                .where(rsnbPr.stock.standardCode.eq(requestDto.stockStndCode),
                        eqRsnbPrcClclMthdName(requestDto.rsnbPrcClclMthdName))
                .fetch();

    }

    private BooleanExpression eqRsnbPrcClclMthdName(String rsnbPrcClclMthdName) {
        if(StringUtils.isEmpty(rsnbPrcClclMthdName)){
            return null;
        }
        return rsnbPr.rsnbPrcClclMthd.methodName.eq(rsnbPrcClclMthdName);
    }
}
