package br.com.sbt.useraccount.config;

import br.com.sbt.useraccount.exception.InvalidCredentialsException;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.ResponseStatus;
import org.springframework.web.bind.annotation.RestControllerAdvice;

import static org.springframework.http.HttpStatus.UNAUTHORIZED;

@RestControllerAdvice
class ControllerAdvice {

    @ExceptionHandler(InvalidCredentialsException.class)
    @ResponseStatus(value = UNAUTHORIZED, reason = "Invalid credentials")
    void handleInvalidCredentialsException() {
        // No content
    }

}
