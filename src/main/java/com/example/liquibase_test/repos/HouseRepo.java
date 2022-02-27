package com.example.liquibase_test.repos;

import com.example.liquibase_test.model.Employee;
import org.springframework.data.jpa.repository.JpaRepository;

/**
 * Created by MadThreeD on 2022.
 */

public interface HouseRepo extends JpaRepository<Employee, Long> {
}
