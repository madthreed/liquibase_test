package com.example.liquibase_test.controllers;

import com.example.liquibase_test.dtos.AnimalDTO;
import com.example.liquibase_test.dtos.EmployeeDTO;
import com.example.liquibase_test.services.AnimalService;
import com.example.liquibase_test.services.EmployeeService;
import org.springframework.web.bind.annotation.*;

import java.util.List;

/**
 * Created by MadThreeD on 2022.
 */

@RestController()
@RequestMapping("/employees")
public class EmployeeController {
    private final EmployeeService employeeService;
    private final AnimalService animalService;

    public EmployeeController(EmployeeService employeeService, AnimalService animalService) {
        this.employeeService = employeeService;
        this.animalService = animalService;
    }

    @GetMapping
    public List<EmployeeDTO> readAll() {
        return employeeService.readAll();
    }

    @GetMapping("{id}")
    public EmployeeDTO read(@PathVariable Long id) {
        return employeeService.read(id);
    }

    @PostMapping()
    public EmployeeDTO create(@RequestBody EmployeeDTO employeeDTO) {
        return employeeService.create(employeeDTO);
    }

    @PutMapping("{id}")
    public EmployeeDTO update(@RequestBody EmployeeDTO employeeDTO, @PathVariable Long id) {
        return employeeService.update(employeeDTO, id);
    }

    @DeleteMapping("{id}")
    public void delete(@PathVariable Long id) {
        employeeService.delete(id);
    }

    @PostMapping("create_some")
    public EmployeeDTO createSome() {
        EmployeeDTO employeeDTO = new EmployeeDTO("Alex", "Busy", "Stoxx");
        employeeDTO.addAnimal(new AnimalDTO("gavgav", "gavker", "2.3"));
        employeeDTO.addAnimal(new AnimalDTO("kiskis", "kisker", "1"));
        employeeDTO.addAnimal(new AnimalDTO("hryuhryu", "hryusher", "3"));

        return employeeService.create(employeeDTO);
    }
}
