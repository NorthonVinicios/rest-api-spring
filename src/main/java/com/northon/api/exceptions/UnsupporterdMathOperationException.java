package com.northon.api.exceptions;

import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.ResponseStatus;

@ResponseStatus(HttpStatus.BAD_REQUEST)
public class UnsupporterdMathOperationException extends RuntimeException{
    public static final long serialVersionUID = 1l;

    public UnsupporterdMathOperationException(String message) {
        super(message);
    }
}
