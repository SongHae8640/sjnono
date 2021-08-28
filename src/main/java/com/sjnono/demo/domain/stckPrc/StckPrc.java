package com.sjnono.demo.domain.stckPrc;


import com.sjnono.demo.domain.stock.Stock;
import lombok.*;

import javax.persistence.*;
import java.time.LocalDateTime;

@Entity
@Table(name = "stck_prc")
@Getter
@NoArgsConstructor(access = AccessLevel.PROTECTED)
public class StckPrc {

    @Id @GeneratedValue
    private Long id;

    @Column(name = "PRC_DATE")
    private String priceDate;

    @ManyToOne(fetch = FetchType.EAGER)
    @JoinColumn(name = "STND_CODE")
    private Stock stock;

    @Column(name = "PRC")
    private int price;

    private LocalDateTime date;
}
