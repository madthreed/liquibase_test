package com.example.liquibase_test.services;

import com.example.liquibase_test.dtos.AnimalDTO;
import com.example.liquibase_test.exceptions.AnimalNotFoundException;
import com.example.liquibase_test.model.Animal;
import com.example.liquibase_test.repos.AnimalRepo;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.stream.Collectors;

@Service
public class AnimalServiceImpl implements AnimalService {
    private final AnimalRepo animalRepo;

    public AnimalServiceImpl(AnimalRepo animalRepo) {
        this.animalRepo = animalRepo;
    }

    @Override
    public List<AnimalDTO> readAll() {
        return animalRepo.findAll()
                .stream().map(AnimalDTO::toDTO)
                .collect(Collectors.toList());
    }

    @Override
    public void create(AnimalDTO animal) {
        animalRepo.save(AnimalDTO.fromDTO(animal));
    }

    @Override
    public AnimalDTO read(Long id) {
        return animalRepo.findById(id)
                .map(AnimalDTO::toDTO).orElseThrow(() -> new AnimalNotFoundException(id));
    }

    @Override
    public AnimalDTO update(AnimalDTO newAnimal, Long id) {
        return animalRepo.findById(id)
                .map(animal -> {
                    animal.setAnimal_name(newAnimal.getAnimal_name());
                    animal.setAge(newAnimal.getAge());
                    animal.setBreed(newAnimal.getBreed());
                    animal.setEmployee(newAnimal.getEmployee());
                    return AnimalDTO.toDTO(animalRepo.save(animal));
                })
                .orElseThrow(() -> new AnimalNotFoundException(id));
    }

    @Override
    public void delete(Long id) {
        animalRepo.deleteById(id);
    }
}
