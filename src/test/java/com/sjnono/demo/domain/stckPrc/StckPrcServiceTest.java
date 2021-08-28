package com.sjnono.demo.domain.stckPrc;

import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

import java.util.List;

@SpringBootTest
public class StckPrcServiceTest {

    @Autowired
    StckPrcService stckPrcService;

    @Test
    public void getStckPrcList() {
        List<StckPrc> stckPrcList =  stckPrcService.findAllByStandardCode("KR7005930003");
        System.out.println(stckPrcList);
        for (StckPrc stckPrc: stckPrcList) {
            ;
            System.out.println(stckPrc.getPrice());
        }



    }


}
