package com.example.liquibase_test.dtos;

import lombok.*;

import java.util.List;


/**
 * Created by MadThreeD on 2022.
 */

@AllArgsConstructor
@RequiredArgsConstructor
@Setter
@Getter
public class EmployeeDTO {
    private String firstname;
    private String lastname;
    private String company;
    private List<AnimalDTO> animals = new java.util.ArrayList<>();

    public EmployeeDTO(String firstname, String lastname, String company) {
        this.firstname = firstname;
        this.lastname = lastname;
        this.company = company;
    }

    public void addAnimal(AnimalDTO animal) {
        this.animals.add(animal);
//        animal.setEmployee_for_animal(this);
    }

    public void removeAnimal(AnimalDTO animal) {
        this.animals.remove(animal);
//        animal.setEmployee_for_animal(null);
    }
}