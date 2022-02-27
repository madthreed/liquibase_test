package com.example.liquibase_test.controllers;

import com.example.liquibase_test.dtos.AnimalDTO;
import com.example.liquibase_test.model.Animal;
import com.example.liquibase_test.services.AnimalService;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
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
    public ResponseEntity<List<AnimalDTO>> readAll() {
        List<AnimalDTO> animals = animalService.readAll();

        return animals != null
                ? new ResponseEntity<>(animals, HttpStatus.OK)
                : new ResponseEntity<>(HttpStatus.NOT_FOUND);
    }

    @GetMapping("{id}")
    public ResponseEntity<AnimalDTO> read(@PathVariable Long id) {
        AnimalDTO animalDto = animalService.read(id);

        return animalDto != null
                ? new ResponseEntity<>(animalDto, HttpStatus.OK)
                : new ResponseEntity<>(HttpStatus.NOT_FOUND);
    }
}
