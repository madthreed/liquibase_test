package com.example.liquibase_test.dtos;

import com.example.liquibase_test.model.House;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.RequiredArgsConstructor;
import lombok.Setter;

import javax.persistence.*;

/**
 * Created by MadThreeD on 2022.
 */

@RequiredArgsConstructor
@AllArgsConstructor
@Setter
@Getter
public class WindowDTO {
    private Boolean isClosed;
}