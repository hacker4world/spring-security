package com.group.security.authentication.exceptions;

import lombok.Getter;

@Getter
public class EmailExistsException extends RuntimeException {
    private final String message;
    public EmailExistsException() {
        this.message = "Email already exists";
    }
}
