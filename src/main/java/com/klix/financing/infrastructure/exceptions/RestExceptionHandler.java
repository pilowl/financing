package com.klix.financing.infrastructure.exceptions;

import org.slf4j.Logger;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.ResponseStatus;
import org.springframework.web.reactive.result.method.annotation.ResponseEntityExceptionHandler;

import com.fasterxml.jackson.databind.JsonMappingException;
import com.klix.financing.infrastructure.errors.BadRequestError;
import com.klix.financing.infrastructure.logger.Slf4jLogger;

@ControllerAdvice
public class RestExceptionHandler extends ResponseEntityExceptionHandler {

    private final Logger logger = Slf4jLogger.getLogger(getClass());

    @ExceptionHandler
    @ResponseStatus(HttpStatus.BAD_REQUEST)
    public ResponseEntity<BadRequestError> handleJsonMappingException(JsonMappingException ex) {
        BadRequestError errorResponse = new BadRequestError("request body isn't good, please fix");
        logger.error("Bad Request occured somewhere", ex);

        return new ResponseEntity<BadRequestError>(errorResponse, HttpStatus.BAD_REQUEST);
    }   
}
