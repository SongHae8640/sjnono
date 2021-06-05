package com.sjnono.demo.domain.stock.dsclInfr;


import com.fasterxml.jackson.dataformat.xml.annotation.JacksonXmlElementWrapper;
import com.fasterxml.jackson.dataformat.xml.annotation.JacksonXmlProperty;
import com.fasterxml.jackson.dataformat.xml.annotation.JacksonXmlRootElement;
import com.sjnono.demo.domain.stock.dsclInfr.DsclInfr;
import lombok.Data;

import javax.xml.bind.annotation.XmlAttribute;
import javax.xml.bind.annotation.XmlElement;
import javax.xml.bind.annotation.XmlRootElement;
import java.util.ArrayList;
import java.util.List;

@Data
public class DisInfoResponseDto {

    @JacksonXmlProperty(localName = "querytime")
    String inquiryTime;


    @JacksonXmlElementWrapper(useWrapping = false)
    List<DisInfo> disInfo = new ArrayList<>();


    @Data
    public static class DisInfo {
        @JacksonXmlProperty(localName = "distime")
        String disclosureDate;

        @JacksonXmlProperty(localName = "disAcpt_no")
        String disclosureAcceptNumber;

        @JacksonXmlProperty(localName = "disTitle")
        String title;

        @JacksonXmlProperty(localName = "submitOblgNm")
        String submitOblgNm;

        public DsclInfr convertDisInfoToDsclInfr(){

            return DsclInfr.builder()
                    .disclosureDate(this.disclosureDate)
                    .disclosureAcceptNumber(this.disclosureAcceptNumber)
                    .title(this.title)
                    .build();

        }

    }

}
