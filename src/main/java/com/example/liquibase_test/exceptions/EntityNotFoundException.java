package com.example.liquibase_test.exceptions;

public class EntityNotFoundException extends RuntimeException {
    public EntityNotFoundException(Long id) {
        super("Could not find animal " + id);
    }
}
