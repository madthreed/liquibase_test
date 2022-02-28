package com.example.liquibase_test.controllers;

import com.example.liquibase_test.dtos.AnimalDTO;
import com.example.liquibase_test.dtos.EmployeeDTO;
import com.example.liquibase_test.dtos.HouseDTO;
import com.example.liquibase_test.dtos.WindowDTO;
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

    public EmployeeController(EmployeeService employeeService) {
        this.employeeService = employeeService;
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


//    @PutMapping("{id}")
//    public EmployeeDTO update(@RequestBody EmployeeDTO employeeDTO, @PathVariable Long id) {
//        return employeeService.update(employeeDTO, id);
//    }


    @DeleteMapping("{id}")
    public void delete(@PathVariable Long id) {
        employeeService.delete(id);
    }


    @PostMapping("create_some")
    public EmployeeDTO createSome() {
        EmployeeDTO employee = new EmployeeDTO("Alex", "Busy", "Stoxx");
        employee.addAnimal(new AnimalDTO("gavgav", "gavker", "2.3"));
        employee.addAnimal(new AnimalDTO("kiskis", "kisker", "1"));
        employee.addAnimal(new AnimalDTO("hryuhryu", "hryusher", "3"));

        WindowDTO window1 = new WindowDTO(true);
        WindowDTO window2 = new WindowDTO(true);
        WindowDTO window3 = new WindowDTO(false);
        WindowDTO window4 = new WindowDTO(false);

        HouseDTO house = new HouseDTO("Lenina avn");
        house.addWindow(window1);
        house.addWindow(window2);
        house.addWindow(window3);
        house.addWindow(window4);

        employee.addHouse(house);

        return employeeService.create(employee);
    }
}
