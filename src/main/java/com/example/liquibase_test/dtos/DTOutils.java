package com.example.liquibase_test.dtos;

import com.example.liquibase_test.model.Animal;
import com.example.liquibase_test.model.Employee;
import com.example.liquibase_test.model.House;
import com.example.liquibase_test.model._Window;

/**
 * Created by MadThreeD on 2022.
 */

public class DTOutils {

    public static WindowDTO windowToDTO(_Window window) {
        WindowDTO windowDTO = new WindowDTO();
        windowDTO.setIsClosed(window.getIsClosed());

        return windowDTO;
    }

    public static _Window windowFromDTO(WindowDTO windowDTO) {
        _Window window = new _Window();
        window.setIsClosed(windowDTO.getIsClosed());

        return window;
    }

    public static HouseDTO houseToDTO(House house) {
        HouseDTO houseDTO = new HouseDTO();
        houseDTO.setAddress(house.getAddress());
        house.getWindows().stream().map(DTOutils::windowToDTO).forEach(houseDTO::addWindow);

        return houseDTO;
    }

    public static House houseFromDTO(HouseDTO houseDTO) {
        House house = new House();
        house.setAddress(houseDTO.getAddress());
        houseDTO.getWindows().stream().map(DTOutils::windowFromDTO).forEach(house::addWindow);

        return house;
    }

    public static AnimalDTO animalToDTO(Animal animal) {
        AnimalDTO animalDto = new AnimalDTO();
        animalDto.setAnimal_name(animal.getAnimal_name());
        animalDto.setAge(animal.getAge());
        animalDto.setBreed(animal.getBreed());

        return animalDto;
    }

    public static Animal animalFromDTO(AnimalDTO animalDTO) {
        Animal animal = new Animal();
        animal.setAnimal_name(animalDTO.getAnimal_name());
        animal.setAge(animalDTO.getAge());
        animal.setBreed(animalDTO.getBreed());

        return animal;
    }

    public static EmployeeDTO employeeToDTO(Employee employee) {
        EmployeeDTO employeeDTO = new EmployeeDTO();

        employeeDTO.setFirstname(employee.getFirstname());
        employeeDTO.setLastname(employee.getLastname());
        employeeDTO.setCompany(employee.getCompany());
        employee.getAnimals().stream().map(DTOutils::animalToDTO).forEach(employeeDTO::addAnimal);
        employee.getHouses().stream().map(DTOutils::houseToDTO).forEach(employeeDTO::addHouse);

        return employeeDTO;
    }

    public static Employee employeeFromDTO(EmployeeDTO employeeDTO) {
        Employee employee = new Employee();

        employee.setFirstname(employeeDTO.getFirstname());
        employee.setLastname(employeeDTO.getLastname());
        employee.setCompany(employeeDTO.getCompany());
        employeeDTO.getAnimals().stream().map(DTOutils::animalFromDTO).forEach(employee::addAnimal);
        employeeDTO.getHouses().stream().map(DTOutils::houseFromDTO).forEach(employee::addHouse);

        return employee;
    }
}
