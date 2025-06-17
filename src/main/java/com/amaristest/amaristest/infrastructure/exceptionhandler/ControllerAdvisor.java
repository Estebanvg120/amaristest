package com.amaristest.amaristest.infrastructure.exceptionhandler;

import com.amaristest.amaristest.infrastructure.exception.ErrorFeignException;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.context.request.WebRequest;

import java.time.LocalDateTime;

@ControllerAdvice
public class ControllerAdvisor {

    @ExceptionHandler(ErrorFeignException.class)
    public ResponseEntity<GlobalExceptionResponse> handleJwtError(ErrorFeignException ex, WebRequest request) {
        return buildErrorResponse(HttpStatus.BAD_REQUEST, ex.getMessage(), request);
    }

    private ResponseEntity<GlobalExceptionResponse> buildErrorResponse(HttpStatus status, String message, WebRequest request) {
        GlobalExceptionResponse error = new GlobalExceptionResponse(
                LocalDateTime.now(),
                status.value(),
                status.getReasonPhrase(),
                message,
                request.getDescription(false).replace("uri=", "")
        );
        return new ResponseEntity<>(error, status);
    }
}
