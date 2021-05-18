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

    @Column(name = "SHRT_CODE")
    String shortCode;

    @Column(name = "KRN_STCK_NAME")
    String koreanStockName;

    @Column(name = "KRN_STCK_SHRT_NAME")
    String koreanStockShortName;

    @Column(name = "ENGL_STCK_NAME")
    String englishStockName;

    @Column(name = "LSTN_DATE")
    String listingDate;

    @Column(name = "MRKT_CLSF")
    String marketClassification;

    @Column(name = "SCRT_CLSF")
    String securitiesClassification;

    @Column(name = "DPRT")
    String department;

    @Column(name = "STCK_TYPE")
    String stockType;

    @Column(name = "FACE_VL")
    String faceValue;

    @Column(name = "NMBR_STCK_LSTN")
    String numberStockListings;

}
