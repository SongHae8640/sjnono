package com.sjnono.demo.common.httpRequest;


import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.dataformat.xml.XmlMapper;
import com.sjnono.demo.domain.stock.dsclInfr.DsclInfrResponseDto;
import org.junit.jupiter.api.Test;


public class xmlToObjectTest {

    XmlMapper xmlMapper = new XmlMapper();

    @Test
    public void krxDisclosureInformationXmlToObject() throws JsonProcessingException {
        String httpResponseXml = "\n" +
                "<?xml version=\"1.0\" encoding=\"utf-8\" ?>\n" +
                "<disclosureMain querytime=\"2021-06-05 23:55:30\" >\n" +
                " <disInfo distime=\"20210517\" disAcpt_no=\"20210517000961\" disTitle=\"분기보고서(일반법인)\" submitOblgNm=\"마이크로컨텍솔루션\"/>\n" +
                " <disInfo distime=\"20210326\" disAcpt_no=\"20210326001088\" disTitle=\"사외이사의선임ㆍ해임또는중도퇴임에관한신고\" submitOblgNm=\"마이크로컨텍솔루션\"/>\n" +
                " <disInfo distime=\"20210326\" disAcpt_no=\"20210326000813\" disTitle=\"정기주주총회결과\" submitOblgNm=\"마이크로컨텍솔루션\"/>\n" +
                " <disInfo distime=\"20210318\" disAcpt_no=\"20210318001776\" disTitle=\"[정정]감사보고서 제출\" submitOblgNm=\"마이크로컨텍솔루션\"/>\n" +
                " <disInfo distime=\"20210318\" disAcpt_no=\"20210318001687\" disTitle=\"[연결포함]사업보고서(일반법인)\" submitOblgNm=\"마이크로컨텍솔루션\"/>\n" +
                " <disInfo distime=\"20210318\" disAcpt_no=\"20210318001640\" disTitle=\"감사보고서 제출\" submitOblgNm=\"마이크로컨텍솔루션\"/>\n" +
                " <disInfo distime=\"20210311\" disAcpt_no=\"20210311000884\" disTitle=\"주주총회 집중일 개최 사유 신고\" submitOblgNm=\"마이크로컨텍솔루션\"/>\n" +
                " <disInfo distime=\"20210311\" disAcpt_no=\"20210311000874\" disTitle=\"주주총회소집공고\" submitOblgNm=\"마이크로컨텍솔루션\"/>\n" +
                " <disInfo distime=\"20210226\" disAcpt_no=\"20210226000154\" disTitle=\"주주총회소집결의\" submitOblgNm=\"마이크로컨텍솔루션\"/>\n" +
                " <disInfo distime=\"20210226\" disAcpt_no=\"20210226000163\" disTitle=\"현금ㆍ현물배당 결정\" submitOblgNm=\"마이크로컨텍솔루션\"/>\n" +
                "</disclosureMain>\n" +
                "\n";

        httpResponseXml = httpResponseXml.trim();

        DsclInfrResponseDto disclosureMain = xmlMapper.readValue(httpResponseXml, DsclInfrResponseDto.class);

        System.out.println(disclosureMain.toString());

    }
}
