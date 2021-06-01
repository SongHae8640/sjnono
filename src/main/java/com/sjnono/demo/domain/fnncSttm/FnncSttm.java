package com.sjnono.demo.domain.fnncSttm;


import com.sjnono.demo.domain.stock.Stock;
import lombok.*;

import javax.persistence.*;

@Entity
@Table(name = "fnnc_sttm")
@Getter
@NoArgsConstructor(access = AccessLevel.PROTECTED)
public class FnncSttm {

    @Id @GeneratedValue
    private Long id;

    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "STND_CODE")
    private Stock stock;

    @Column(name = "BASE_YEAR")
    private String baseYear;

    @Column(name = "BASE_QRTR")
    private String baseQuarter;


}
