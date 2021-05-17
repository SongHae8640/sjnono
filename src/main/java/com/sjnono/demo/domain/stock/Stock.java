package com.sjnono.demo.domain.stock;

import lombok.*;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;

@Entity
@Getter
@AllArgsConstructor
@NoArgsConstructor
@Builder
@ToString
public class Stock {

    @Id
    @Column(name = "STND_CODE")
    String standardCode;

    @Column(name = "KRN_STCK_NAME")
    String koreanStockName;
}
