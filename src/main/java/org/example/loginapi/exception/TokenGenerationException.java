package org.example.loginapi.exception;

import lombok.NoArgsConstructor;

@NoArgsConstructor

public class TokenGenerationException extends RuntimeException {
    public TokenGenerationException(String message) {
        super(message);
    }
}
