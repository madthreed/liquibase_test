package com.example.liquibase_test.model;

import lombok.*;

import javax.persistence.*;
import java.util.List;

/**
 * Created by MadThreeD on 2022.
 */
//@NamedEntityGraph(
//        name = "house-with-windows",
//        attributeNodes = {
//                @NamedAttributeNode("windows")
//        }
//)

@Entity
@RequiredArgsConstructor
@AllArgsConstructor
@Setter
@Getter
public class House {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    private String address;

    @ManyToOne//(fetch = FetchType.LAZY)
    private Employee employee;


    @OneToMany(mappedBy = "house",
            cascade = CascadeType.ALL)
    private List<_Window> windows = new java.util.ArrayList<>();


    public void addWindow(_Window window) {
        this.windows.add(window);
        window.setHouse(this);
    }


    public void removeWindow(_Window window) {
        this.windows.remove(window);
        window.setHouse(null);
    }
}