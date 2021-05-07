package com.zunde.userManagement.exceptions;

import org.springframework.http.HttpStatus;
import org.springframework.web.server.ResponseStatusException;

public class AlreadyExistsException extends ResponseStatusException {

    public AlreadyExistsException(HttpStatus status, String message) {
        super(status, message);

    }

}
