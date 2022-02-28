package com.example.liquibase_test.services.excluded;

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
                .stream().map(DTOutils::animalToDTO)
                .collect(Collectors.toList());
    }

    @Override
    public AnimalDTO create(AnimalDTO animalDTO) {
        return DTOutils.animalToDTO(animalRepo.save(DTOutils.animalFromDTO(animalDTO)));
    }

    @Override
    public AnimalDTO read(Long id) {
        return animalRepo.findById(id)
                .map(DTOutils::animalToDTO).orElseThrow(() -> new EntityNotFoundException(id));//EntityNotFoundException(id));
    }

    @Override
    public AnimalDTO update(AnimalDTO newAnimal, Long id) {
        Animal animalFromDb = animalRepo.findById(id).orElseThrow(() -> new EntityNotFoundException(id));
        Animal animal = DTOutils.animalFromDTO(newAnimal);

        animalFromDb.setAnimal_name(animal.getAnimal_name());
        animalFromDb.setBreed(animal.getBreed());
        animalFromDb.setAge(animal.getAge());
        animalFromDb.setEmployee(animal.getEmployee());

        return DTOutils.animalToDTO(animalRepo.save(animal));

//                .map(animal -> {
//                    animal.setId(id);
//                    animal.setAnimal_name(newAnimal.getAnimal_name());
//                    animal.setAge(newAnimal.getAge());
//                    animal.setBreed(newAnimal.getBreed());
//                    animal.setEmployee(DTOutils.employeeFromDTO(newAnimal.getEmployee()));
//                    return DTOutils.animalToDTO(animalRepo.save(animal));
//                })
//                .orElseThrow(() -> new EntityNotFoundException(id));
//        return animalDTO;
    }

    @Override
    public void delete(Long id) {
        Animal animal = animalRepo.findById(id)
                .orElseThrow(() -> new EntityNotFoundException(id));

        animalRepo.delete(animal);
    }
}
