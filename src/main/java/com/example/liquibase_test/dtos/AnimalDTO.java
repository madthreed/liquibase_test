package com.example.liquibase_test.dtos;

import lombok.*;


/**
 * Created by MadThreeD on 2022.
 */

//@AllArgsConstructor
@RequiredArgsConstructor
@Setter
@Getter
public class AnimalDTO {
    private String animal_name;
    private String breed;
    private String age;
//    private EmployeeDTO employee_for_animal;

    public AnimalDTO(String animal_name, String breed, String age) {
        this.animal_name = animal_name;
        this.breed = breed;
        this.age = age;
    }
}