package com.sjnono.demo.domain.stock.dsclInfr;

import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.dataformat.xml.XmlMapper;
import com.sjnono.demo.common.httpRequest.RestService;
import com.sjnono.demo.domain.stock.Stock;
import com.sjnono.demo.domain.stock.StockRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.ArrayList;
import java.util.List;

@Service
@RequiredArgsConstructor
public class DsclInfrService {

    private final DsclInfrRepository dsclInfrRepository;

    private final StockRepository stockRepository;

    private final RestService restService;


    @Transactional
    public void tt(){

        List<Stock> stockList = this.stockRepository.findAll();

        for (Stock stock : stockList) {
            List<DsclInfr> dsclInfrList = getDisclosureInformationInKrx(stock.getShortCode());

            //신규 공시정보이면 저장

                //분기보고서 or 사업보고서 이면 파이썬 서버에 크롤링 요청

        }
    }

    public List<DsclInfr> getDisclosureInformationInKrx(String stockShortCode)  {
        String krxDisclosureInformationUrl = "http://asp1.krx.co.kr/servlet/krx.asp.DisList4MainServlet?gubun=K";
        String stockStandardCodeOption = "&code=";

        String httpResponseXml = restService.requestHttpGet(krxDisclosureInformationUrl+stockStandardCodeOption+stockShortCode);
        httpResponseXml = httpResponseXml.trim();

        XmlMapper xmlMapper = new XmlMapper();
        DisInfoResponseDto disclosureMain = null;
        try {
            disclosureMain = xmlMapper.readValue(httpResponseXml, DisInfoResponseDto.class);
        } catch (JsonProcessingException e) {
            e.printStackTrace();
        }

        List<DisInfoResponseDto.DisInfo> disInfoList = disclosureMain.getDisInfo();

        List<DsclInfr> dsclInfrList = new ArrayList<>();

        for (DisInfoResponseDto.DisInfo disInfo: disInfoList) {
            dsclInfrList.add(disInfo.convertDisInfoToDsclInfr());
        }

        return dsclInfrList;

    }

}
