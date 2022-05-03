package com.self.user.configuration;

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.RestControllerAdvice;

@RestControllerAdvice
public class GlobalExceptionErrorHandler {

    @ExceptionHandler(RuntimeException.class)
    public ResponseEntity<String> error(RuntimeException e){
        return new ResponseEntity<String>("RestControllerAdvice : " + e.getMessage() , HttpStatus.INTERNAL_SERVER_ERROR);
    }

}
