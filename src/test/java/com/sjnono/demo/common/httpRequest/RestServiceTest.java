package com.sjnono.demo.common.httpRequest;

import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.dataformat.xml.XmlMapper;
import com.sjnono.demo.domain.stock.dsclInfr.DsclInfrResponseDto;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

@SpringBootTest
class RestServiceTest {

    @Autowired
    RestService restService;

    @Test
    public void getDisclosureInformationInKrx() throws JsonProcessingException {
        String krxDisclosureInformationUrl = "http://asp1.krx.co.kr/servlet/krx.asp.DisList4MainServlet?gubun=K";
        String stockStandardCodeOption = "&code=";
        String stockShortCode = "005930";    //삼성전자

        String httpResponseXml = restService.requestHttpGet(krxDisclosureInformationUrl+stockStandardCodeOption+stockShortCode);
        httpResponseXml = httpResponseXml.trim();

        XmlMapper xmlMapper = new XmlMapper();
        DsclInfrResponseDto disclosureMain = xmlMapper.readValue(httpResponseXml, DsclInfrResponseDto.class);

        System.out.println(disclosureMain.toString());


    }
}