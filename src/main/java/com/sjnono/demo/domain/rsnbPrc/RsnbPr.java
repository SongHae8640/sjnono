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
    private Long id;

    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "FNNC_STTM_ID")
    private FnncSttm fnncSttm;

    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "STCK_STND_CODE")
    private Stock stock;

    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "RSNB_PRC_CLCL_MTHD_ID")
    private RsnbPrcClclMthd rsnbPrcClclMthd;

    @Column(name = "DSCN_RATE")
    private String discountRate;


    @Column(name = "DATE")
    private String date;

    @Column(name = "RSNB_PRC")
    private int reasonablePrice;




}
