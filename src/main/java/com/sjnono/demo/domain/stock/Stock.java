package com.sjnono.demo.domain.stock;

import lombok.*;

import javax.persistence.*;

@Entity
@Table(name = "stock")
@Getter
@NoArgsConstructor(access = AccessLevel.PROTECTED)
public class Stock {

    @Id @Column(name = "STND_CODE")
    private String standardCode;

    @Column(name = "SHRT_CODE")
    private String shortCode;

    @Column(name = "KRN_STCK_NAME")
    private String koreanStockName;

    @Column(name = "KRN_STCK_SHRT_NAME")
    private String koreanStockShortName;

    @Column(name = "ENGL_STCK_NAME")
    private String englishStockName;

    @Column(name = "LSTN_DATE")
    private String listingDate;

    @Column(name = "MRKT_CLSF")
    private String marketClassification;

    @Column(name = "SCRT_CLSF")
    private String securitiesClassification;

    @Column(name = "DPRT")
    private String department;

    @Column(name = "STCK_TYPE")
    @Enumerated(EnumType.STRING)
    private StockType stockType;

    @Column(name = "FACE_VL")
    private String faceValue;

    @Column(name = "NMBR_STCK_LSTN")
    private String numberStockListings;

}
