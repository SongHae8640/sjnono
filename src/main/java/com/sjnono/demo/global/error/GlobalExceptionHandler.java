package com.sjnono.demo.global.error;

import lombok.extern.slf4j.Slf4j;
import org.springframework.hateoas.EntityModel;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.RestControllerAdvice;

@Slf4j
@RestControllerAdvice
public class GlobalExceptionHandler {

    @ExceptionHandler(CustomException.class)
    public ResponseEntity customExceptionHandler(CustomException ce) {
        log.error("#################################################");
        log.error("## ErrorEnum: " + ce.getErrorEnum());
        log.error("## Link: " + ce.getLink());
        log.error("#################################################");

        EntityModel<ErrorEnum> model = EntityModel.of(ce.getErrorEnum())
                .add(ce.getLink());

        return ResponseEntity
                .status(ce.getErrorEnum().getHttpStatus())
                .body(model);
    }
}
