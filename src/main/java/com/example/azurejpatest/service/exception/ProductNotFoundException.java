package com.example.azurejpatest.service.exception;

import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.ResponseStatus;

@ResponseStatus(code = HttpStatus.BAD_REQUEST)
public class ProductNotFoundException extends Throwable{
    public ProductNotFoundException(String message) {
        super(message);
    }
}
