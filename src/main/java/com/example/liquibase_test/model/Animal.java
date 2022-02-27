package com.example.liquibase_test.model;

import lombok.*;

import javax.persistence.*;

/**
 * Created by MadThreeD on 2022.
 */

@Entity
@AllArgsConstructor
@RequiredArgsConstructor
@Setter
@Getter
@ToString
public class Animal {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    private String animal_name;
    private String breed;
    private String age;

    @ManyToOne
    @JoinColumn(name = "employee_id")
    private Employee employee;
}