package com.example.liquibase_test.controllers.excluded;

import com.example.liquibase_test.dtos.AnimalDTO;
import com.example.liquibase_test.services.excluded.AnimalService;
import org.springframework.web.bind.annotation.*;

import java.util.List;

/**
 * Created by MadThreeD on 2022.
 */

/**
 * Created by MadThreeD on 2022.
 */

@RestController()
@RequestMapping("/animals")
public class AnimalController {
    private final AnimalService animalService;

    public AnimalController(AnimalService animalService) {
        this.animalService = animalService;
    }

    @GetMapping
    public List<AnimalDTO> readAll() {
        return animalService.readAll();
    }

    @GetMapping("{id}")
    public AnimalDTO read(@PathVariable Long id) {
        return animalService.read(id);
    }

    @PostMapping()
    public AnimalDTO create(@RequestBody AnimalDTO animalDTO) {
        return animalService.create(animalDTO);
    }

    @PutMapping("{id}")
    public AnimalDTO update(@RequestBody AnimalDTO animalDTO, @PathVariable Long id) {
        return animalService.update(animalDTO, id);
    }

    @DeleteMapping("{id}")
    public void delete(@PathVariable Long id) {
        animalService.delete(id);
    }
}
