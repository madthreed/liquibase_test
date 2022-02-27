package com.example.liquibase_test.model;

import lombok.Getter;
import lombok.RequiredArgsConstructor;
import lombok.Setter;

import javax.persistence.*;
import java.util.List;

/**
 * Created by MadThreeD on 2022.
 */

@Entity
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

    @OneToMany
    private List<Animal> animals = new java.util.ArrayList<>();

//    @OneToMany
//    private List<House> houses = new java.util.ArrayList<>();
}