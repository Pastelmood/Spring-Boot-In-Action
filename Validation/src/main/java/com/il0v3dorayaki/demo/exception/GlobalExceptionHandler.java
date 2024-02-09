package com.il0v3dorayaki.demo.exception;

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.validation.FieldError;
import org.springframework.web.bind.MethodArgumentNotValidException;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;

import java.util.ArrayList;
import java.util.List;

@ControllerAdvice
public class GlobalExceptionHandler {

    @ExceptionHandler
    public ResponseEntity<GlobalExceptionResponse> handleException(MethodArgumentNotValidException exception) {

        List<String> errerList = new ArrayList<>();
        List<FieldError> fieldErrorList = exception.getFieldErrors();

        if (!fieldErrorList.isEmpty()) {
            for (FieldError fieldError : fieldErrorList) {
                errerList.add(fieldError.getDefaultMessage());
            }
        }

        GlobalExceptionResponse error = new GlobalExceptionResponse();
        error.setStatus(HttpStatus.BAD_REQUEST.value());
        error.setErrors(errerList);

        return new ResponseEntity<>(error, HttpStatus.BAD_REQUEST);

    }
}
