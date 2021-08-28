package com.sjnono.demo.domain.stock;

import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.web.servlet.AutoConfigureMockMvc;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.web.servlet.MockMvc;
import org.springframework.test.web.servlet.ResultActions;

import static org.junit.jupiter.api.Assertions.*;
import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.put;
import static org.springframework.test.web.servlet.result.MockMvcResultHandlers.print;

@SpringBootTest
@AutoConfigureMockMvc
class StockRestControllerTest {

    @Autowired
    MockMvc mockMvc;

    @Test
    public void 주식_카테고리_업데이트() throws Exception {
        // GIVEN
        String url = "/api/stock/category";

        // WHEN
        ResultActions actions = mockMvc.perform(put(url));

        // THEN
        actions.andDo(print());

    }
}