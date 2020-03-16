package com.projeto.catalog.exception;

public class RegisterProductUseCaseExeception extends Exception {
    public RegisterProductUseCaseExeception(String message) {
        super(message);
    }

    public RegisterProductUseCaseExeception(String message, Throwable cause) {
        super(message, cause);
    }
}
