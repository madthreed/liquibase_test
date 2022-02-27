package com.example.liquibase_test.model;

import lombok.*;

import javax.persistence.*;

@Entity
@AllArgsConstructor
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

    public Animal(String animal_name, String breed, String age, Employee employee) {
    }
}