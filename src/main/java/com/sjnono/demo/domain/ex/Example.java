package com.sjnono.demo.domain.ex;

import com.sjnono.demo.domain.stckPrc.StckPrc;
import com.sjnono.demo.domain.stock.Stock;
import lombok.*;

import javax.persistence.*;

@Entity
@Getter
@Builder
@NoArgsConstructor
@AllArgsConstructor
@SequenceGenerator(name = "EX_SEQ_GEN", sequenceName = "EX_SEQ_GEN", initialValue = 7)
public class Example {
    @Id @GeneratedValue(strategy = GenerationType.IDENTITY, generator = "EX_SEQ_GEN")
    Long id;

    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "STND_CODE")
    Stock stock;

}