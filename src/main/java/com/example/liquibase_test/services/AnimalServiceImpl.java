package com.example.liquibase_test.services;

import com.example.liquibase_test.dtos.AnimalDTO;
import com.example.liquibase_test.dtos.DTOutils;
import com.example.liquibase_test.exceptions.EntityNotFoundException;
import com.example.liquibase_test.model.Animal;
import com.example.liquibase_test.repos.AnimalRepo;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.stream.Collectors;

/**
 * Created by MadThreeD on 2022.
 */

@Service
public class AnimalServiceImpl implements AnimalService {
    private final AnimalRepo animalRepo;

    public AnimalServiceImpl(AnimalRepo animalRepo) {
        this.animalRepo = animalRepo;
    }

    @Override
    public List<AnimalDTO> readAll() {
        return animalRepo.findAll()
                .stream().map(DTOutils::toDTO)
                .collect(Collectors.toList());
    }

    @Override
    public AnimalDTO create(AnimalDTO animalDTO) {
        Animal animal = DTOutils.fromDTO(animalDTO);
        Animal newAnimal = animalRepo.save(animal);
        return DTOutils.toDTO(newAnimal);
    }

    @Override
    public AnimalDTO read(Long id) {
        return animalRepo.findById(id)
                .map(DTOutils::toDTO).orElseThrow(() -> new EntityNotFoundException(id));//EntityNotFoundException(id));
    }

    @Override
    public AnimalDTO update(AnimalDTO newAnimal, Long id) {
        return animalRepo.findById(id)
                .map(animal -> {
                    animal.setAnimal_name(newAnimal.getAnimal_name());
                    animal.setAge(newAnimal.getAge());
                    animal.setBreed(newAnimal.getBreed());
                    animal.setEmployee(newAnimal.getEmployee());
                    return DTOutils.toDTO(animalRepo.save(animal));
                })
                .orElseThrow(() -> new EntityNotFoundException(id));
    }

    @Override
    public void delete(Long id) {
        Animal animal = animalRepo.findById(id)
                .orElseThrow(() -> new EntityNotFoundException(id));

        animalRepo.delete(animal);
    }
}
