package com.sjnono.demo.domain.ex;

import com.sjnono.demo.domain.ex.entity.Example;
import com.sjnono.demo.domain.ex.service.ExService;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

@SpringBootTest
class ExServiceTest {

    @Autowired
    ExService exService;

    @Test
    public void getExampleById(){
        Example example = this.exService.findById(1L);

        System.out.println(example.getId());
        System.out.println(example.getStock().toString());

    }

}