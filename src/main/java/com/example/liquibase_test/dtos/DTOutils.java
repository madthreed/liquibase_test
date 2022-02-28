package com.example.liquibase_test.dtos;

import com.example.liquibase_test.model.Animal;
import com.example.liquibase_test.model.Employee;

import java.util.stream.Collectors;

/**
 * Created by MadThreeD on 2022.
 */

public class DTOutils {

    public static AnimalDTO animalToDTO(Animal animal) {
        AnimalDTO animalDto = new AnimalDTO();
        animalDto.setAnimal_name(animal.getAnimal_name());
        animalDto.setAge(animal.getAge());
        animalDto.setBreed(animal.getBreed());
//        animalDto.setEmployee_for_animal(animalDto.getEmployee_for_animal());

        return animalDto;
    }

    public static Animal animalFromDTO(AnimalDTO animalDTO) {
        Animal animal = new Animal();
        animal.setAnimal_name(animalDTO.getAnimal_name());
        animal.setAge(animalDTO.getAge());
        animal.setBreed(animalDTO.getBreed());
        animal.setEmployee_for_animal(animal.getEmployee_for_animal());

        return animal;
    }

    public static EmployeeDTO employeeToDTO(Employee employee) {
        EmployeeDTO employeeDTO = new EmployeeDTO();

        employeeDTO.setFirstname(employee.getFirstname());
        employeeDTO.setLastname(employee.getLastname());
        employeeDTO.setCompany(employee.getCompany());
        employee.getAnimals().stream().map(DTOutils::animalToDTO).forEach(employeeDTO::addAnimal);

        return employeeDTO;
    }

    public static Employee employeeFromDTO(EmployeeDTO employeeDTO) {
        Employee employee = new Employee();

        employee.setFirstname(employeeDTO.getFirstname());
        employee.setLastname(employeeDTO.getLastname());
        employee.setCompany(employeeDTO.getCompany());
        employeeDTO.getAnimals().stream().map(DTOutils::animalFromDTO).forEach(employee::addAnimal);

        return employee;
    }
}
