package org.example.loginapi.exception;

import lombok.NoArgsConstructor;

@NoArgsConstructor

public class UserServiceException extends RuntimeException {
    public UserServiceException(String message) {
        super(message);
    }
}
