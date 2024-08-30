package org.example.loginapi.exception;

import lombok.NoArgsConstructor;

@NoArgsConstructor
public class AccountAlreadyExistsException extends RuntimeException {

    public AccountAlreadyExistsException(String message) {
        super(message);
    }
}