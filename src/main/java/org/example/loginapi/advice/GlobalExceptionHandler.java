package org.example.loginapi.advice;

import org.example.loginapi.exception.*;
import org.example.loginapi.model.response.ErrorResponseDTO;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.validation.FieldError;
import org.springframework.web.bind.MethodArgumentNotValidException;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.ResponseStatus;
import org.springframework.web.bind.annotation.RestControllerAdvice;

import java.util.HashMap;
import java.util.Map;

@RestControllerAdvice
public class GlobalExceptionHandler {

    @ExceptionHandler(UsernameNotFoundException.class)
    public ResponseEntity<ErrorResponseDTO> handleUsernameNotFoundException() {
        Map<String, String> errors = new HashMap<>();
        errors.put("username", "Username not found in the system.");
        return new ResponseEntity<>(
                ErrorResponseDTO.builder()
                        .message("Username Not Found!")
                        .status(HttpStatus.NOT_FOUND).errors(errors)
                        .build(), HttpStatus.NOT_FOUND);
    }

    @ExceptionHandler(InvalidPasswordException.class)
    public ResponseEntity<ErrorResponseDTO> handleInvalidPassword() {
        return new ResponseEntity<>(
                ErrorResponseDTO.builder().message("Invalid password or username!").status(HttpStatus.UNAUTHORIZED).build(), HttpStatus.UNAUTHORIZED);
    }

    @ExceptionHandler(KeyGenerationException.class)
    public ResponseEntity<ErrorResponseDTO> handleKeyGenerationException() {
        return new ResponseEntity<>(ErrorResponseDTO.builder().message("Unexpected error occurred while generating signing key.").status(HttpStatus.INTERNAL_SERVER_ERROR).build(), HttpStatus.INTERNAL_SERVER_ERROR);
    }

    @ExceptionHandler(TokenGenerationException.class)
    public ResponseEntity<ErrorResponseDTO> handleTokenGenerationException() {
        return new ResponseEntity<>(ErrorResponseDTO.builder().message("An error occurred while generating token").status(HttpStatus.INTERNAL_SERVER_ERROR).build(), HttpStatus.INTERNAL_SERVER_ERROR);
    }

    @ExceptionHandler(UserAlreadyExistsException.class)
    public ResponseEntity<ErrorResponseDTO> handleUserAlreadyExistsException() {
        Map<String, String> errors = new HashMap<>();
        errors.put("user", "User already exists in the system.");
        return new ResponseEntity<>(ErrorResponseDTO.builder().errors(errors).message("User already exist").status(HttpStatus.FORBIDDEN).build(), HttpStatus.FORBIDDEN);
    }

    @ExceptionHandler(AccountNotFoundException.class)
    public ResponseEntity<ErrorResponseDTO> handleAccountNotFoundException() {
        Map<String, String> errors = new HashMap<>();
        errors.put("account", "Bank account is not found.");
        return new ResponseEntity<>(ErrorResponseDTO.builder().errors(errors).message("Bank Account with sent iban is not found").status(HttpStatus.NOT_FOUND).build(), HttpStatus.NOT_FOUND);
    }

    @ExceptionHandler(AccountAlreadyExistsException.class)
    public ResponseEntity<ErrorResponseDTO> handleAccountAlreadyExistsException() {
        Map<String, String> errors = new HashMap<>();
        errors.put("account", "Bank account already exists.");
        return new ResponseEntity<>(ErrorResponseDTO.builder().errors(errors).message("Bank Account Already exist!").status(HttpStatus.FORBIDDEN).build(), HttpStatus.FORBIDDEN);
    }

    @ExceptionHandler(AccountServiceException.class)
    public ResponseEntity<ErrorResponseDTO> handleAccountServiceException() {
        return new ResponseEntity<>(ErrorResponseDTO.builder().message("An error occurred in bank account service").status(HttpStatus.INTERNAL_SERVER_ERROR).build(), HttpStatus.INTERNAL_SERVER_ERROR);
    }

    @ExceptionHandler(MethodArgumentNotValidException.class)
    @ResponseStatus(HttpStatus.BAD_REQUEST)
    @ResponseBody
    public ResponseEntity<ErrorResponseDTO> handleValidationExceptions(MethodArgumentNotValidException ex) {
        Map<String, String> errors = new HashMap<>();
        ex.getBindingResult().getAllErrors().forEach((error) -> {
            String fieldName = ((FieldError) error).getField();
            String errorMessage = error.getDefaultMessage();
            errors.put(fieldName, errorMessage);
        });
        return new ResponseEntity<>(
                ErrorResponseDTO.builder()
                        .message("An error occurred in bank account service")
                        .status(HttpStatus.BAD_REQUEST)
                        .errors(errors)
                        .build(), HttpStatus.BAD_REQUEST);
    }

}
