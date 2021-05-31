package com.sjnono.demo.domain.stckPrc;


import com.sjnono.demo.domain.stock.Stock;
import lombok.*;

import javax.persistence.*;

@Entity
@Table(name = "stck_prc")
@Getter
@NoArgsConstructor(access = AccessLevel.PROTECTED)
public class StckPrc {

    @Id @GeneratedValue
    Long id;

    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "STND_CODE")
    Stock stock;

    @Column(name = "PRC")
    int price;

    String date;
}
