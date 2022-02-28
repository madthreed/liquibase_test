package com.example.liquibase_test.services;

import com.example.liquibase_test.dtos.DTOutils;
import com.example.liquibase_test.dtos.EmployeeDTO;
import com.example.liquibase_test.exceptions.EntityNotFoundException;
import com.example.liquibase_test.model.Employee;
import com.example.liquibase_test.repos.EmployeeRepo;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.stream.Collectors;

/**
 * Created by MadThreeD on 2022.
 */

@Service
public class EmployeeServiceImpl implements EmployeeService {
    private final EmployeeRepo employeeRepo;

    public EmployeeServiceImpl(EmployeeRepo employeeRepo) {
        this.employeeRepo = employeeRepo;
    }

    @Override
    public List<EmployeeDTO> readAll() {
        return employeeRepo.findAll()
                .stream().map(DTOutils::employeeToDTO)
                .collect(Collectors.toList());
    }

    @Override
    public EmployeeDTO create(EmployeeDTO employeeDTO) {
        return DTOutils.employeeToDTO(employeeRepo.save(DTOutils.employeeFromDTO(employeeDTO)));
    }

    @Override
    public EmployeeDTO read(Long id) {
        return employeeRepo.findById(id)
                .map(DTOutils::employeeToDTO).orElseThrow(() -> new EntityNotFoundException(id));//EntityNotFoundException(id));
    }

    //todo i don't know how this make alive

    @Override
    public EmployeeDTO update(EmployeeDTO newEmployee, Long id) {
        Employee employee = employeeRepo.findById(id).orElseThrow(() -> new EntityNotFoundException(id));

//        employee.setFirstname(newEmployee.getFirstname());
//        employee.setLastname(newEmployee.getLastname());
//        employee.setCompany(newEmployee.getCompany());
//        employee.setAnimals(newEmployee.getAnimals().stream().map(DTOutils::animalFromDTO).collect(Collectors.toList()));
//
//        return DTOutils.employeeToDTO(employeeRepo.save(employee));

        return DTOutils.employeeToDTO(employee);
    }

    @Override
    public void delete(Long id) {
        Employee employee = employeeRepo.findById(id)
                .orElseThrow(() -> new EntityNotFoundException(id));

        employeeRepo.delete(employee);
    }
}
