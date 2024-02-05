package com.klix.financing.infrastructure.exceptions;

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.ResponseStatus;
import org.springframework.web.reactive.result.method.annotation.ResponseEntityExceptionHandler;

import com.fasterxml.jackson.databind.JsonMappingException;
import com.klix.financing.infrastructure.errors.BadRequestError;

@ControllerAdvice
public class RestExceptionHandler extends ResponseEntityExceptionHandler {

      @ExceptionHandler
      @ResponseStatus(HttpStatus.BAD_REQUEST)
      public ResponseEntity<BadRequestError> handleJsonMappingException(JsonMappingException ex) {
          BadRequestError errorResponse = new BadRequestError("request body isn't good, please fix");
          return new ResponseEntity<BadRequestError>(errorResponse, HttpStatus.BAD_REQUEST);
      }   
}
