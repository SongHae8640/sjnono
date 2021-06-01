package com.sjnono.demo.domain.ex.entity;

import com.sjnono.demo.domain.stock.Stock;
import lombok.*;
import org.hibernate.annotations.Cascade;

import javax.persistence.*;

@Entity
@Table(name = "example")
@Getter
@NoArgsConstructor(access = AccessLevel.PROTECTED)
@SequenceGenerator(name = "EX_SEQ_GEN", sequenceName = "EX_SEQ_GEN", initialValue = 7)
public class Example {
    @Id @GeneratedValue(strategy = GenerationType.IDENTITY, generator = "EX_SEQ_GEN")
    Long id;

    @ManyToOne(fetch = FetchType.LAZY, cascade = CascadeType.ALL)
    @JoinColumn(name = "STND_CODE")
    Stock stock;

    // == 연관관계 편의 메서드 == //
    public void setStock(Stock stock) {
        this.stock = stock;
        // this.stock.getExample().add(this); 양방향일 경우
    }

    // == 생성 메서드 == //
    public static Example createExample(Stock stock) {
        Example example = new Example();
        example.setStock(stock);
        return example;
    }
}
