package com.example.liquibase_test.model;

import lombok.*;

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


    @OneToMany(mappedBy = "employee",
            cascade = CascadeType.ALL)
    private List<Animal> animals = new java.util.ArrayList<>();


    @OneToMany(mappedBy = "employee",
            cascade = CascadeType.ALL)
    private List<House> houses = new java.util.ArrayList<>();


    public void addAnimal(Animal animal) {
        this.animals.add(animal);
        animal.setEmployee(this);
    }


    public void removeAnimal(Animal animal) {
        this.animals.remove(animal);
        animal.setEmployee(null);
    }


    public void addHouse(House house) {
        this.houses.add(house);
        house.setEmployee(this);
    }


    public void removeHouse(House house) {
        this.houses.remove(house);
        house.setEmployee(null);
    }
}