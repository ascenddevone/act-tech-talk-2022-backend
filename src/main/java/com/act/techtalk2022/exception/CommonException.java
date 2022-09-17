package com.act.techtalk2022.exception;

import org.springframework.http.HttpStatus;

public class CommonException extends RuntimeException {
    private final HttpStatus status;

    private final String code;

    private final String message;

    public CommonException(String code, String message) {
        super(message);
        this.status = HttpStatus.BAD_REQUEST;
        this.code = code;
        this.message = message;
    }


    public CommonException(HttpStatus status, String code, String message) {
        super(message);
        this.status = status;
        this.code = code;
        this.message = message;
    }

    public HttpStatus getStatus() {
        return status;
    }

    public String getCode() {
        return code;
    }

    @Override
    public String getMessage() {
        return message;
    }
}