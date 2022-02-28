package com.example.liquibase_test.model;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.RequiredArgsConstructor;
import lombok.Setter;

import javax.persistence.*;
import java.util.List;

/**
 * Created by MadThreeD on 2022.
 */

@Entity
@AllArgsConstructor
@RequiredArgsConstructor
@Setter
@Getter
public class Employee {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    private String firstname;
    private String lastname;
    private String company;

    @OneToMany(mappedBy = "employee_for_animal",
            cascade = CascadeType.ALL)
    private List<Animal> animals = new java.util.ArrayList<>();

//    @OneToMany
//    private List<House> houses = new java.util.ArrayList<>();

    public void addAnimal(Animal animal) {
        this.animals.add(animal);
        animal.setEmployee_for_animal(this);
    }

    public void removeAnimal(Animal animal) {
        this.animals.remove(animal);
        animal.setEmployee_for_animal(null);
    }
}