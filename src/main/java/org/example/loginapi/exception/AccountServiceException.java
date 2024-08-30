package org.example.loginapi.exception;

import lombok.NoArgsConstructor;

@NoArgsConstructor
public class AccountServiceException extends RuntimeException {
    public AccountServiceException(String message) {
        super(message);
    }
}