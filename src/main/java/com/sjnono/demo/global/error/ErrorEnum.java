package com.sjnono.demo.global.error;

import com.fasterxml.jackson.annotation.JsonFormat;
import lombok.AllArgsConstructor;
import lombok.Getter;
import org.springframework.http.HttpStatus;

@Getter @AllArgsConstructor
@JsonFormat(shape = JsonFormat.Shape.OBJECT) // Enum을 JSON 형식으로 변환
public enum ErrorEnum {
    INVALID_PARAMETER(HttpStatus.BAD_REQUEST, "Invalid Request Data"),
    NOT_FOUND(HttpStatus.NOT_FOUND, "Not Found Data"),
    UNAUTHORIZED(HttpStatus.UNAUTHORIZED, "Unauthorized User");

    private final HttpStatus httpStatus;
    private final String message;
}
