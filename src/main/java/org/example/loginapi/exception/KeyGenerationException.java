package org.example.loginapi.exception;

import lombok.NoArgsConstructor;

@NoArgsConstructor
public class KeyGenerationException extends RuntimeException {
    public KeyGenerationException(String message) {
        super(message);
    }
}

