package com.sjnono.demo.domain.ex;

import com.fasterxml.jackson.databind.ObjectMapper;
import com.sjnono.demo.global.error.ErrorEnum;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.web.servlet.AutoConfigureMockMvc;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.http.MediaType;
import org.springframework.test.web.servlet.MockMvc;
import org.springframework.test.web.servlet.ResultActions;

import java.util.HashMap;
import java.util.Map;

import static org.hamcrest.Matchers.is;
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

    @Test
    public void 예제_단일건수조회_BadRequest() throws Exception {
        // GIVEN
        String url = "/api/ex/-1";
        // WHEN
        ResultActions actions = mockMvc.perform(get(url));
        // THEN
        actions.andDo(print())
                .andExpect(status().isBadRequest())
                .andExpect(jsonPath("httpStatus").exists())
                .andExpect(jsonPath("message").exists())
                .andExpect(jsonPath("_links.self").exists())
        ;
    }

    @Test
    public void 예제_페이지네이션() throws Exception {
        // GIVEN
        String urlTemplate = "/api/ex";

        // WHEN
        ResultActions actions = mockMvc.perform(get(urlTemplate));

        // THEN
        actions.andDo(print())
                .andExpect(status().isOk())
                .andExpect(jsonPath("page").exists())
                .andExpect(jsonPath("_embedded.exampleAllResponseList[0]._links.self").exists())
        ;
    }

    @Test
    public void 예제_페이지네이션_BadRequest() throws Exception {
        // GIVEN
        String urlTemplate = "/api/ex";

        // WHEN
        ResultActions actions = mockMvc.perform(get(urlTemplate)
                .param("page", "-1")
                .param("size", "3")
                .param("sort", "id,ASC"));

        // THEN
        actions.andDo(print())
                .andExpect(status().isBadRequest())
                .andExpect(jsonPath("httpStatus").exists())
                .andExpect(jsonPath("message").exists())
                .andExpect(jsonPath("_links.self").exists())
        ;
    }

    @Test
    void 예제_삽입() throws Exception {
        /**
         * 기본키가 삽입으로 인한 준영속 엔티티
         * merge가 실행되어 SELECT문이 1회 실행됐던 문제 수정 (cascade를 주면 같이 수정 또는 변경된다.)
         */
        // Given
        Map<String, Object> param = new HashMap<>();
        param.put("standardCode", "KR7000540005");

        // When
        ResultActions actions = mockMvc.perform(post("/api/ex")
                .contentType(MediaType.APPLICATION_JSON)
                .content(objectMapper.writeValueAsString(param)));

        // Then
        actions.andDo(print())
                .andExpect(status().isOk())
                .andExpect(jsonPath("standardCode").exists())
                .andExpect(jsonPath("koreanStockName").exists())
                .andExpect(jsonPath("_links.self").exists())
        ;
    }


}