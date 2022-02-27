package com.example.liquibase_test.repos;

import com.example.liquibase_test.model.Employee;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.repository.CrudRepository;

/**
 * Created by MadThreeD on 2022.
 */

public interface EmployeeRepo extends JpaRepository<Employee, Long> {
}
