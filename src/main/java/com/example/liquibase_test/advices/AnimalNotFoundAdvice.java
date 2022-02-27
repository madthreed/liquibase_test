package com.example.liquibase_test.advices;

import com.example.liquibase_test.exceptions.AnimalNotFoundException;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.ResponseStatus;

@ControllerAdvice
public class AnimalNotFoundAdvice {
    @ResponseBody
    @ExceptionHandler(AnimalNotFoundException.class)
    @ResponseStatus(HttpStatus.NOT_FOUND)
    String animalNotFoundHandler(AnimalNotFoundException e) {
        return e.getMessage();
    }
}
