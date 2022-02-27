package com.example.liquibase_test.dtos;

import com.example.liquibase_test.model.Animal;

/**
 * Created by MadThreeD on 2022.
 */

public class DTOutils {

    public static AnimalDTO toDTO(Animal animal) {
        AnimalDTO animalDto = new AnimalDTO();
        animalDto.setAnimal_name(animal.getAnimal_name());
        animalDto.setAge(animal.getAge());
        animalDto.setBreed(animal.getBreed());
        animalDto.setEmployee(animal.getEmployee());

        return animalDto;
    }

    public static Animal fromDTO(AnimalDTO animalDTO) {
        Animal animal = new Animal();
        animal.setAnimal_name(animalDTO.getAnimal_name());
        animal.setAge(animalDTO.getAge());
        animal.setBreed(animalDTO.getBreed());
        animal.setEmployee(animal.getEmployee());

        return animal;
    }
}
