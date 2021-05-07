package com.zunde.userManagement.exceptions;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import java.time.ZonedDateTime;
@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
public class UserException {
    private  String message;
    private  int httpStatus;
    private ZonedDateTime timestamp;

}
