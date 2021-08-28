package com.sjnono.demo.domain.stckPrc;

import com.fasterxml.jackson.databind.ObjectMapper;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.web.servlet.AutoConfigureMockMvc;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.web.servlet.MockMvc;
import org.springframework.test.web.servlet.ResultActions;
import org.springframework.test.web.servlet.request.MockMvcRequestBuilders;
import org.springframework.test.web.servlet.result.MockMvcResultHandlers;

@SpringBootTest
@AutoConfigureMockMvc
public class StckPrcControllerTest {

    @Autowired
    MockMvc mockMvc;

    @Autowired
    ObjectMapper objectMapper;


    @Test
    public void getStckPrc() throws Exception {
        ResultActions actions = mockMvc.perform(MockMvcRequestBuilders.get("/stckPrc/KR7005930003"));

        actions.andDo(MockMvcResultHandlers.print());


    }
}
