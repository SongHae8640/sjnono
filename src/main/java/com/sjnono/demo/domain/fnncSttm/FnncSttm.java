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
    Integer id;


    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "STND_CODE")
    Stock stock;

    @Column(name = "BASE_YEAR")
    String baseYear;

    @Column(name = "BASE_QRTR")
    String baseQuarter;


}
