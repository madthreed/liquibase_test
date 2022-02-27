package com.example.liquibase_test.dtos;

import com.example.liquibase_test.model.Animal;
import com.example.liquibase_test.model.Employee;
import lombok.*;

import javax.persistence.*;


@AllArgsConstructor
@RequiredArgsConstructor
@Setter
@Getter
@ToString
public class AnimalDTO {
    private String animal_name;
    private String breed;
    private String age;
    private Employee employee;


    public static AnimalDTO toDTO(Animal animal) {
        return new AnimalDTO(animal.getAnimal_name(), animal.getBreed(), animal.getAge(), animal.getEmployee());
    }

    public static Animal fromDTO(AnimalDTO animalDTO) {
        return new Animal(animalDTO.getAnimal_name(), animalDTO.getBreed(), animalDTO.getAge(), animalDTO.getEmployee());
    }
}