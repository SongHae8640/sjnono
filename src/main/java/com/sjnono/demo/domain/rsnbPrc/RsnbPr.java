package com.sjnono.demo.domain.rsnbPrc;


import com.sjnono.demo.domain.fnncSttm.FnncSttm;
import com.sjnono.demo.domain.rsnbPrcClclMthd.RsnbPrcClclMthd;
import com.sjnono.demo.domain.stock.Stock;
import lombok.*;

import javax.persistence.*;

@Entity
@Getter
@AllArgsConstructor
@NoArgsConstructor
@Builder
@ToString
public class RsnbPr {

    @Id
    Integer id;

    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "ID")
    FnncSttm fnncSttm;

    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "STND_CODE")
    Stock stock;

    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "ID")
    RsnbPrcClclMthd rsnbPrcClclMthd;

    @Column(name = "DSCN_RATE")
    String discountRate;


    @Column(name = "DATE")
    String date;

    @Column(name = "RSNB_PRC")
    int reasonablePrice;




}
