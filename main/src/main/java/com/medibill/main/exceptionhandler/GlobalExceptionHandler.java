package com.medibill.main.exceptionhandler;

import java.time.LocalDateTime;
import java.util.UUID;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;

@ControllerAdvice
public class GlobalExceptionHandler {
    
    @ExceptionHandler(LoggedRuntimeException.class)
    public ResponseEntity<ErrorResponse> handleLoggedRuntimeException(LoggedRuntimeException e) {
        ErrorResponse errorResponse = new ErrorResponse();
            errorResponse.setStatusCode(HttpStatus.NOT_FOUND.value());
            errorResponse.setMessage(e.getMessage());
            errorResponse.setTime(LocalDateTime.now());
            errorResponse.setExceptionId(UUID.randomUUID().toString());
        return new ResponseEntity<>(errorResponse, HttpStatus.NOT_FOUND);
    }

    @ExceptionHandler
    public ResponseEntity<ErrorResponse> handleException(Exception e){
        ErrorResponse errorResponse = new ErrorResponse();
        errorResponse.setStatusCode(HttpStatus.NOT_FOUND.value());
        errorResponse.setMessage(e.getMessage());
        errorResponse.setTime(LocalDateTime.now());
        errorResponse.setExceptionId(UUID.randomUUID().toString());
        return  new ResponseEntity<>(errorResponse,  HttpStatus.BAD_REQUEST);
    }
}
