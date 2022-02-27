package com.example.liquibase_test.model;

import lombok.Getter;
import lombok.RequiredArgsConstructor;
import lombok.Setter;
import lombok.ToString;

import javax.persistence.*;

@Entity
@RequiredArgsConstructor
@Setter
@Getter
@ToString
public class Animal {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "id", nullable = false)
    private Long id;

    private String animal_name;
    private String breed;
    private String age;

    @ManyToOne
    @JoinColumn(name = "employee_id")
    private Employee employee;

}