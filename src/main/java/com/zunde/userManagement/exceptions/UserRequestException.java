package com.zunde.userManagement.exceptions;


import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.ResponseStatus;

@ResponseStatus(value = HttpStatus.NOT_FOUND)
public class UserRequestException extends RuntimeException {
    public UserRequestException(String message, Throwable cause) {
        super(message, cause);

    }

    public UserRequestException(String message) {
        super(message);

    }


}
