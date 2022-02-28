package com.example.liquibase_test.dtos;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.RequiredArgsConstructor;
import lombok.Setter;

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
    private List<HouseDTO> houses = new java.util.ArrayList<>();

    public EmployeeDTO(String firstname, String lastname, String company) {
        this.firstname = firstname;
        this.lastname = lastname;
        this.company = company;
    }


    public void addAnimal(AnimalDTO animal) {
        this.animals.add(animal);
    }


    public void removeAnimal(AnimalDTO animal) {
        this.animals.remove(animal);
    }


    public void addHouse(HouseDTO house) {
        this.houses.add(house);
    }


    public void removeHouse(HouseDTO house) {
        this.houses.remove(house);
    }
}