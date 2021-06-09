package com.sjnono.demo.global.error;

import lombok.Getter;
import org.springframework.hateoas.Link;
import org.springframework.validation.Errors;

@Getter
public class CustomException extends RuntimeException {
    private ErrorEnum errorEnum;
    private Link link;

    public CustomException(ErrorEnum errorEnum, Link link) {
        super(errorEnum.getMessage());

        this.errorEnum = errorEnum;
        this.link = link;
    }
}
