package com.il0v3dorayaki.demo.exception;

import java.util.ArrayList;
import java.util.List;

public class GlobalExceptionResponse {

    private int status;
    private List<String> errors = new ArrayList<>();

    public GlobalExceptionResponse() {
    }

    public GlobalExceptionResponse(int status, List<String> errors) {
        this.status = status;
        this.errors = errors;
    }

    public List<String> getErrors() {
        return errors;
    }

    public void setErrors(List<String> errors) {
        this.errors = errors;
    }

    public int getStatus() {
        return status;
    }

    public void setStatus(int status) {
        this.status = status;
    }
}
