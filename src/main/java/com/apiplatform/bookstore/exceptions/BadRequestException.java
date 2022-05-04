package com.apiplatform.bookstore.exceptions;

import com.apiplatform.bookstore.Errors.Error;

import java.util.List;

public class BadRequestException extends RuntimeException {

    private List<Error> errors;

    public BadRequestException(String message, List<Error> errors) {
        super(message);
        this.errors = errors;
    }

    public List<Error> getErrors() {
        return errors;
    }

    public void setErrors(List<Error> errors) {
        this.errors = errors;
    }
}
