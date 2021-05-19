package com.sjnono.demo.domain.ex;

import com.sjnono.demo.domain.stckPrc.StckPrc;
import com.sjnono.demo.domain.stock.Stock;

import javax.persistence.*;

@Entity
public class Example {
    @Id
    Long id;

    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "STND_CODE")
    Stock stock;
}
