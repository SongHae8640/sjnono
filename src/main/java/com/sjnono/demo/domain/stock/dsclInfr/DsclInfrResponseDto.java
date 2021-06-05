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
public class DsclInfrResponseDto {

    @JacksonXmlProperty(localName = "querytime")
    String inquiryTime;


    @JacksonXmlElementWrapper(useWrapping = false)
    List<DsclInfr> disInfo = new ArrayList<>();


    @Data
    private static class DsclInfr {
        @JacksonXmlProperty(localName = "distime")
        String disclosureDate;

        @JacksonXmlProperty(localName = "disAcpt_no")
        String disclosureAcceptNumber;

        @JacksonXmlProperty(localName = "disTitle")
        String title;

        @JacksonXmlProperty(localName = "submitOblgNm")
        String submitOblgNm;
    }

}
