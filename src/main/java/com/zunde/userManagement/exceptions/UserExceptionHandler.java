package com.zunde.userManagement.exceptions;

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;

import java.time.ZoneId;
import java.time.ZonedDateTime;

@ControllerAdvice
public class UserExceptionHandler {
    @ExceptionHandler(value = {UserRequestException.class})


    public ResponseEntity<Object> handler(UserRequestException exception){
        int httpStatus = 409;

        UserException userException = new UserException(exception.getMessage(),
                httpStatus, ZonedDateTime.now(ZoneId.of("Z")));

        return new ResponseEntity<>(userException, HttpStatus.BAD_REQUEST);
    }
}
