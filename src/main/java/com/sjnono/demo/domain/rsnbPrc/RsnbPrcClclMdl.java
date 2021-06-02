package com.sjnono.demo.domain.rsnbPrc;

import com.sjnono.demo.domain.fnncSttm.FnncSttm;
import com.sjnono.demo.domain.rsnbPrc.RsnbPr;
import org.springframework.stereotype.Component;

import java.util.ArrayList;
import java.util.List;

/**
 * 적정각격계산 모듈
 * 재무제표가 입력으로 들어오면 여러 방법으로 산정된 적정가격 리스트를 반환한다.
 */

@Component
public class RsnbPrcClclMdl {

    public List<RsnbPr> calRsnbPrcAll(FnncSttm fnncSttm){
        List<RsnbPr> rsnbPrList = new ArrayList<>();

        rsnbPrList.add(this.warrenBuffettCal(fnncSttm));


        return rsnbPrList;
    }

    private RsnbPr warrenBuffettCal(FnncSttm fnncSttm) {


        return null;
    }


    //적정가격 계산 방법 추가시 산정 메서드 생성
}
