package com.getir.retailbook;

import com.getir.retailbook.util.MessageConstant;
import com.mongodb.DuplicateKeyException;
import com.mongodb.MongoWriteException;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.ResponseStatus;
import org.springframework.web.bind.annotation.RestControllerAdvice;

@RestControllerAdvice
public class MongoExceptionHandler {
    Logger logger = LoggerFactory.getLogger(MongoExceptionHandler.class);

    @ResponseStatus(HttpStatus.INTERNAL_SERVER_ERROR)
    @ExceptionHandler(value = DuplicateKeyException.class)
    public ErrorResponse handleDuplicateKeyException(DuplicateKeyException e) {
        logger.error(e.getMessage(), e);
        return new ErrorResponse(MessageConstant.CANNOT_CREATE_SAME_ENTITY, HttpStatus.INTERNAL_SERVER_ERROR);
    }

    @ResponseStatus(HttpStatus.INTERNAL_SERVER_ERROR)
    @ExceptionHandler(value = MongoWriteException.class)
    public ErrorResponse handleMongoWriteException(MongoWriteException e) {
        logger.error(e.getMessage(), e);
        return new ErrorResponse(MessageConstant.SOMETHING_WENT_WRONG_WITH_MONGO, HttpStatus.INTERNAL_SERVER_ERROR);
    }
}
