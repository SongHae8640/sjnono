package com.sjnono.demo.domain.ex;

import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Component;

@Component
public class ExValidator {


    public void getOneValidate(Long exId) {

        if (exId < 0 ){

        }
    }

    public void getListValidate(Pageable pageable) {

        if(pageable.getPageNumber() <1){

        }
    }
}
