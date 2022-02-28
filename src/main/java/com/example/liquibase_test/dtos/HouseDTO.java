package com.example.liquibase_test.dtos;

import lombok.Getter;
import lombok.RequiredArgsConstructor;
import lombok.Setter;

import java.util.List;

/**
 * Created by MadThreeD on 2022.
 */

@RequiredArgsConstructor
@Setter
@Getter
public class HouseDTO {
    private String address;
    private List<WindowDTO> windows = new java.util.ArrayList<>();

    public HouseDTO(String address) {
        this.address = address;
    }

    public void addWindow(WindowDTO windowDTO) {
        this.windows.add(windowDTO);
//        windowDTO.setHouse(this);
    }

    public void removeWindow(WindowDTO windowDTO) {
        this.windows.remove(windowDTO);
//        windowDTO.setHouse(null);
    }
}