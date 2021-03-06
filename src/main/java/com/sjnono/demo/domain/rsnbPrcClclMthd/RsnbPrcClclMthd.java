package com.sjnono.demo.domain.rsnbPrcClclMthd;


import lombok.*;

import javax.persistence.*;

@Entity
@Table(name = "rsnb_prc_clcl_mthd")
@Getter
@NoArgsConstructor(access = AccessLevel.PROTECTED)
public class RsnbPrcClclMthd {

    @Id @GeneratedValue
    private Long id;

    @Column(name = "MTHD_NAME")
    private String methodName;

}
