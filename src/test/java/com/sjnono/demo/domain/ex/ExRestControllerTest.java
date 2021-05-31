package com.sjnono.demo.domain.ex;

import com.fasterxml.jackson.databind.ObjectMapper;
import com.sjnono.demo.domain.stock.Stock;
import com.sjnono.demo.global.error.ErrorEnum;
import lombok.RequiredArgsConstructor;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.web.servlet.AutoConfigureMockMvc;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.http.MediaType;
import org.springframework.test.web.servlet.MockMvc;
import org.springframework.test.web.servlet.ResultActions;
import org.springframework.test.web.servlet.request.MockMvcRequestBuilders;
import org.springframework.test.web.servlet.result.MockMvcResultHandlers;
import org.springframework.test.web.servlet.result.MockMvcResultMatchers;
import org.springframework.web.servlet.function.RequestPredicates;

import static org.hamcrest.Matchers.is;
import static org.junit.jupiter.api.Assertions.*;
import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.*;
import static org.springframework.test.web.servlet.result.MockMvcResultHandlers.*;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.*;


@SpringBootTest
@AutoConfigureMockMvc
class ExRestControllerTest {

    @Autowired
    MockMvc mockMvc;

    @Autowired
    ObjectMapper objectMapper;

    @Test
    void 예제_단일건수조회_성공() throws Exception {
        ResultActions actions = mockMvc.perform(get("/api/ex/1"));

        actions.andDo(print())
                .andExpect(status().isOk())
                .andExpect(jsonPath("standardCode").exists())
                .andExpect(jsonPath("koreanStockName").exists())
                .andExpect(jsonPath("_links.self").exists())
        ;

    }

    @Test
    public void 예제_단일건수조회_NotFound() throws Exception {
        // GIVEN
        String url = "/api/ex/100";

        // WHEN
        ResultActions actions = mockMvc.perform(get(url));

        // THEN
        actions.andDo(print())
                .andExpect(status().isNotFound())
                .andExpect(jsonPath("httpStatus").value(is(ErrorEnum.NOT_FOUND.toString())))
                .andExpect(jsonPath("message").exists())
                .andExpect(jsonPath("_links.self").exists())
        ;
    }

    // TODO 하위 테스트 필요
    @Test
    void getExampleList() throws Exception {
        ResultActions actions = mockMvc.perform(get("/api/ex?page=0"));

        actions.andDo(print())
        ;
    }

    /*
    @Test
    void insertExample() throws Exception{
        Example example = Example.builder()
                .stock(Stock.builder()
                        .standardCode("KR7000540005")
                        .build())
                .build();

        ResultActions actions = mockMvc.perform(post("/api/ex")
                                    .contentType(MediaType.APPLICATION_JSON)
                                    .content(objectMapper.writeValueAsString(example)));

        actions.andDo(print())

        ;

    }
     */


}