package com.rseat.vacancy_management.modules.candidate.exceptions;

public class UserFoundException extends RuntimeException {
    public UserFoundException() {
        super("User already exists");
    }
}
