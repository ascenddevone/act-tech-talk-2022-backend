package com.act.techtalk2022.controller;

import com.act.techtalk2022.controller.response.GeneralResponse;
import com.act.techtalk2022.exception.CommonException;
import com.act.techtalk2022.factory.ResponseFactory;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.core.Ordered;
import org.springframework.core.annotation.Order;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.ResponseBody;

import java.io.IOException;
import java.lang.reflect.InvocationTargetException;

@Order(Ordered.HIGHEST_PRECEDENCE)
@Slf4j
@RequiredArgsConstructor
@ControllerAdvice
public class ExceptionHandlerController {

    private final ResponseFactory responseFactory;


    @ExceptionHandler({
            InvocationTargetException.class,
            IOException.class,
            NullPointerException.class,
            Exception.class,})
    @ResponseBody
    public ResponseEntity<GeneralResponse<Object>> handleException(Exception error) {
        log.error("handleException", error);

        return responseFactory.error(HttpStatus.INTERNAL_SERVER_ERROR, "general_error", "General Error");
    }



    @ExceptionHandler({CommonException.class})
    @ResponseBody
    public ResponseEntity<GeneralResponse<Object>> handleCommonException(CommonException error) {

        log.error("handleCommonException", error);

        return responseFactory.error(error.getStatus(), error.getCode(), error.getMessage());
    }
}