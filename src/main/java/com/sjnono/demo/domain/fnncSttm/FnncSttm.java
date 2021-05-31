package com.sjnono.demo.domain.fnncSttm;


import com.sjnono.demo.domain.stock.Stock;
import lombok.*;

import javax.persistence.*;

@Entity
@Getter
@AllArgsConstructor
@NoArgsConstructor
@Builder
@ToString
public class FnncSttm {

    @Id
    Long id;


    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "STND_CODE")
    Stock stock;

    @Column(name = "BASE_YEAR")
    String baseYear;

    @Column(name = "BASE_QRTR")
    String baseQuarter;

    String invn;    //재고자산

    String othrCrntFnncAsts;  //기타유동금융자산

    String crntTaxAsts;   //당기법인세자산

    String othrCrntAsts;   //기타유동자산

    String crntAsts;   //유동자산


    // 유동자산 = 재고자산 + 기타유동금융자산 + 당기법인세자산 + 기타유동자산
    public void calCrntAsts() {
        this.crntAsts = invn + othrCrntFnncAsts + crntTaxAsts + othrCrntAsts;
    }
}
