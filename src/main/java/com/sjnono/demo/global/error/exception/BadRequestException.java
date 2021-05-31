package com.sjnono.demo.global.error.exception;

import com.sjnono.demo.global.error.CustomException;
import com.sjnono.demo.global.error.ErrorEnum;
import org.springframework.hateoas.Link;

public class BadRequestException extends CustomException {

    public BadRequestException(Link link) {
        super(ErrorEnum.INVALID_PARAMETER, link);
    }
}
