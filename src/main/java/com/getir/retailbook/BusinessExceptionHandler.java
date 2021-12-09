package com.getir.retailbook;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.ResponseStatus;
import org.springframework.web.bind.annotation.RestControllerAdvice;

import javax.servlet.http.HttpServletRequest;

@RestControllerAdvice
public class BusinessExceptionHandler {
    Logger logger = LoggerFactory.getLogger(BusinessExceptionHandler.class);

    @ResponseStatus(HttpStatus.INTERNAL_SERVER_ERROR)
    @ExceptionHandler(value = BusinessException.class)
    public ErrorResponse defaultErrorHandler(HttpServletRequest req, BusinessException e) {
        logger.error(e.getMsg(), e);
        return new ErrorResponse(e.getMsg(), HttpStatus.INTERNAL_SERVER_ERROR);
    }
}
