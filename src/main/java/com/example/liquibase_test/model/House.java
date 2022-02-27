package com.example.liquibase_test.model;

import lombok.Getter;
import lombok.RequiredArgsConstructor;
import lombok.Setter;
import lombok.ToString;

import javax.persistence.*;

/**
 * Created by MadThreeD on 2022.
 */

//@Entity
@RequiredArgsConstructor
@Setter
@Getter
@ToString
public class House {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "id", nullable = false)
    private Long id;

    private String address;

    @ManyToOne
    @JoinColumn(name = "employee_id")
    private Employee employee;
}