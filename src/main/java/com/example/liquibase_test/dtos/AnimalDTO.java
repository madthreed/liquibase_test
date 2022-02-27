package com.example.liquibase_test.dtos;

import com.example.liquibase_test.model.Employee;
import lombok.*;


/**
 * Created by MadThreeD on 2022.
 */

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
}