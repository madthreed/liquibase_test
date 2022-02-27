package com.example.liquibase_test.controllers;

import com.example.liquibase_test.model.Animal;
import com.example.liquibase_test.services.AnimalService;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController()
@RequestMapping("/animals")
public class AnimalController {
    private final AnimalService animalService;

    public AnimalController(AnimalService animalService) {
        this.animalService = animalService;
    }

    @GetMapping
    List<Animal> getAllAnimals() {
        return null;
    }

    @PostMapping
    void add(@RequestBody Animal animal) {
    }
}
