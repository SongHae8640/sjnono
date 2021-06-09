package com.sjnono.demo.global.error.exception;

import com.sjnono.demo.global.error.CustomException;
import com.sjnono.demo.global.error.ErrorEnum;
import org.springframework.hateoas.Link;

public class NotFoundException extends CustomException {

    public NotFoundException(Link link) {
        super(ErrorEnum.NOT_FOUND, link);
    }
}
