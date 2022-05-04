package com.apiplatform.bookstore.exceptions;

import com.apiplatform.bookstore.utils.APIResponse;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;

@ControllerAdvice
public class GlobalExceptionHandler {

    @ExceptionHandler
    public ResponseEntity handlerBadRequestException(BadRequestException badRequestException) {
        APIResponse response = new APIResponse();
        response.setStatus(HttpStatus.BAD_REQUEST.value());
        response.setError(badRequestException.getErrors());
        return ResponseEntity.status(HttpStatus.BAD_REQUEST.value()).body(response);
    }

    @ExceptionHandler
    public ResponseEntity handlerAccessDeniedException(AccessDeniedException accessDeniedException) {
        APIResponse apiResponse = new APIResponse();
        apiResponse.setStatus(HttpStatus.UNAUTHORIZED.value());
        return ResponseEntity.status(apiResponse.getStatus()).body(apiResponse);
    }
}
