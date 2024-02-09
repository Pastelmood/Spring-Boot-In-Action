package com.il0v3dorayaki.demo.exception;

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.servlet.resource.NoResourceFoundException;

@ControllerAdvice
public class AppExceptionHandle {

    @ExceptionHandler
    public ResponseEntity<AppExceptionResponse> handleException(NoResourceFoundException exception) {

        // create a AppExceptionResponse
        AppExceptionResponse error = new AppExceptionResponse();
        error.setStatus(HttpStatus.OK.value());
        error.setMessage("Path Not Found");

        //  return ResponseEntity
        return new ResponseEntity<>(error, HttpStatus.OK);
    }
}
