package com.sjnono.demo.domain.ex;

import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

import static org.junit.jupiter.api.Assertions.*;

@SpringBootTest
class ExServiceTest {

    @Autowired
    ExService exService;

    @Test
    public void getExampleById(){
        Example example = this.exService.findById(1L);

        System.out.println(example.id);
        System.out.println(example.stock.toString());

    }

}