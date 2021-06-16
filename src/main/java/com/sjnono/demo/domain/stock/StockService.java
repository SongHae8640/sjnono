package com.sjnono.demo.domain.stock;

import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.databind.ObjectMapper;
import com.sjnono.demo.global.error.exception.NotFoundException;
import lombok.RequiredArgsConstructor;
import net.minidev.json.JSONObject;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.*;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;
import org.springframework.util.LinkedMultiValueMap;
import org.springframework.util.MultiValueMap;
import org.springframework.web.client.RestTemplate;

import java.util.List;
import java.util.Map;
import java.util.Optional;

import static org.springframework.hateoas.server.mvc.WebMvcLinkBuilder.linkTo;

@Service
@RequiredArgsConstructor
@Transactional(readOnly = true)
public class StockService {

    private final StockRepository stockRepository;
    private final ObjectMapper objectMapper;

    public Stock getStockDetail(String standardCode) {
        return stockRepository.findByStandardCode(standardCode);
    }

    public Stock saveStock(Stock stock){
        return null;
    }

    public List<Stock> getStockList(String shrIpt){
        /*
        List<Stock> stockList = stockRepository.findAllByShortCodeStartsWithOrKoreanStockNameStartsWith(shrIpt,shrIpt);
        return stockList;
         */
        return null;
    }

    public List<Stock> findAllStock() {
        return stockRepository.findAll();
    }

    @Transactional
    public void updateStockCategories(List<Stock> stocks) {

        stocks.stream().forEach(stock -> {
            // Make Body
            MultiValueMap<String, String> body = new LinkedMultiValueMap<>();
            body.add("bld", "dbms/MDC/STAT/standard/MDCSTAT02103");
            body.add("isuCd", stock.getStandardCode());

            // Make headers
            HttpHeaders httpHeaders = new HttpHeaders();
            httpHeaders.setContentType(MediaType.APPLICATION_FORM_URLENCODED);
//            httpHeaders.add("user-agent", "Mozilla/5.0 (Windows NT 10.0; Win64; x64) AppleWebKit/537.36 (KHTML, like Gecko) Chrome/54.0.2840.99 Safari/537.36");

            HttpEntity<MultiValueMap<String, String>> entity = new HttpEntity<>(body, httpHeaders);

            RestTemplate restTemplate = new RestTemplate();

            ResponseEntity<String> exchange = restTemplate.exchange(
                    "http://data.krx.co.kr/comm/bldAttendant/getJsonData.cmd",
                    HttpMethod.POST,
                    entity,
                    String.class
            );

            String getBody = exchange.getBody();
            Map map = null;
            try {
                map = objectMapper.readValue(getBody, Map.class);
            } catch (JsonProcessingException e) {
                e.printStackTrace();
            }
            String category = map.get("IND_NM").toString();

            // modify category
            Stock findStock = stockRepository.findById(stock.getStandardCode()).get();
            findStock.setStockCategory(category);

            try {
                Thread.sleep(200);
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
        });
    }
}
