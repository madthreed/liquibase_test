package com.example.liquibase_test.repos;

import com.example.liquibase_test.model.Employee;
import org.springframework.data.jpa.repository.EntityGraph;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.Optional;

/**
 * Created by MadThreeD on 2022.
 */
public interface EmployeeRepo extends JpaRepository<Employee, Long> {
    @EntityGraph("employee-with-animals")
    Optional<Employee> findOneWithAnimalsById(Long aLong);

    @EntityGraph("employee-with-houses")
    Optional<Employee> findOneWithHousesById(Long aLong);
}
