package com.sjnono.demo.domain.stock.dsclInfr;

import com.sjnono.demo.domain.stock.Stock;
import lombok.*;

import javax.persistence.*;

/**
 * 공시정보 Entity
 * */

@Entity
@Getter
@AllArgsConstructor
@NoArgsConstructor
@Builder
@ToString
public class DsclInfr {

    @Id
    Long Id;

    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "STND_CODE")
    Stock stock;

    @Column(name = "DSCL_DATE")
    String disclosureDate;

    @Column(name = "DSCL_ACPT_NMBR")
    String disclosureAcceptNumber;

    @Column(name = "TTL")
    String title;



}
