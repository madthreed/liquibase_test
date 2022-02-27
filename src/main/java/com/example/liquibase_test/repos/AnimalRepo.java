package com.example.liquibase_test.repos;

import com.example.liquibase_test.model.Animal;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.repository.CrudRepository;

public interface AnimalRepo extends JpaRepository<Animal,Long> {
}
