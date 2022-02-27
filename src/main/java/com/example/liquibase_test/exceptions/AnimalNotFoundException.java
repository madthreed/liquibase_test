package com.example.liquibase_test.exceptions;

public class AnimalNotFoundException extends RuntimeException {
    public AnimalNotFoundException(Long id) {
        super("Could not find animal " + id);
    }
}
