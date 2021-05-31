package com.sjnono.demo.domain.rsnbPrc;


import com.sjnono.demo.domain.fnncSttm.FnncSttm;
import com.sjnono.demo.domain.rsnbPrcClclMthd.RsnbPrcClclMthd;
import com.sjnono.demo.domain.stock.Stock;
import lombok.*;

import javax.persistence.*;

@Entity
@Table(name = "rsnb_pr")
@Getter
@NoArgsConstructor(access = AccessLevel.PROTECTED)
public class RsnbPr {

    @Id @GeneratedValue
    Long id;

    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "FNNC_STTM_ID")
    FnncSttm fnncSttm;

    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "STCK_STND_CODE")
    Stock stock;

    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "RSNB_PRC_CLCL_MTHD_ID")
    RsnbPrcClclMthd rsnbPrcClclMthd;

    @Column(name = "DSCN_RATE")
    String discountRate;


    @Column(name = "DATE")
    String date;

    @Column(name = "RSNB_PRC")
    int reasonablePrice;




}
