package com.sjnono.demo.domain.rsnbPrcClclMthd;


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
public class RsnbPrcClclMthd {

    @Id
    Integer id;

    @Column(name = "MTHD_NAME")
    String methodName;

}
