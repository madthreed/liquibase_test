package com.example.liquibase_test.model;

import lombok.*;

import javax.persistence.*;

/**
 * Created by MadThreeD on 2022.
 */

@Entity
@RequiredArgsConstructor
@AllArgsConstructor
@Setter
@Getter
public class _Window {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    private Boolean isClosed;

    @ManyToOne(fetch = FetchType.LAZY)
    private House house;
}