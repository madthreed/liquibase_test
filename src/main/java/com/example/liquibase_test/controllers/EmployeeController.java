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
        return employeeService.readById(id);
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
    public void createSome() {
        EmployeeDTO employee1 = new EmployeeDTO("Alex", "Busy", "Stoxx");
        employee1.addAnimal(new AnimalDTO("gavgav", "gavker", "2.3"));
        employee1.addAnimal(new AnimalDTO("kiskis", "kisker", "1"));
        employee1.addAnimal(new AnimalDTO("hryuhryu", "hryusher", "3"));

        HouseDTO house1 = new HouseDTO("Lenina avn");
        house1.addWindow(new WindowDTO(true));
        house1.addWindow(new WindowDTO(true));
        house1.addWindow(new WindowDTO(false));
        house1.addWindow(new WindowDTO(false));
        employee1.addHouse(house1);

        HouseDTO house2 = new HouseDTO("Stalin avn");
        house2.addWindow(new WindowDTO(true));
        house2.addWindow(new WindowDTO(true));
        house2.addWindow(new WindowDTO(true));
        house2.addWindow(new WindowDTO(false));
        employee1.addHouse(house2);




        EmployeeDTO employee2 = new EmployeeDTO("Vasya", "Pupkin", "MMM");
        employee2.addAnimal(new AnimalDTO("simba", "lion", "6"));
        employee2.addAnimal(new AnimalDTO("kotya", "cat", "2"));

        HouseDTO house3 = new HouseDTO("Lenina avn");
        house3.addWindow(new WindowDTO(true));
        house3.addWindow(new WindowDTO(true));
        house3.addWindow(new WindowDTO(false));
        employee2.addHouse(house3);

        HouseDTO house4 = new HouseDTO("Stalin avn");
        house4.addWindow(new WindowDTO(true));
        house4.addWindow(new WindowDTO(true));
        employee2.addHouse(house4);

        employeeService.create(employee1);
        employeeService.create(employee2);

//        return employeeService.create(employee1);
    }
}
