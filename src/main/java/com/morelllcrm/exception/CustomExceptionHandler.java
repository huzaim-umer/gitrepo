package com.morelllcrm.exception;

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.context.request.WebRequest;

@RestController
@ControllerAdvice
public class CustomExceptionHandler {

    @ExceptionHandler
    public final ResponseEntity userAlreadyExists(UserAlreadyExists ex, WebRequest wr){
        UserAlreadyExistsResponse pir= new UserAlreadyExistsResponse(ex.getMessage());
        return new ResponseEntity(pir, HttpStatus.BAD_REQUEST );
    }

    @ExceptionHandler
    public final ResponseEntity userNotFound(UserNotFoundException ex, WebRequest wr){
        UserNotFoundExceptionResponse pir= new UserNotFoundExceptionResponse(ex.getMessage());
        return new ResponseEntity(pir, HttpStatus.BAD_REQUEST );
    }

    @ExceptionHandler
    public final ResponseEntity userNotVerified(UserNotVerifiedException ex, WebRequest wr){
        UserNotVerifiedExceptionResponse pir= new UserNotVerifiedExceptionResponse(ex.getMessage());
        return new ResponseEntity(pir, HttpStatus.BAD_REQUEST );
    }
}
