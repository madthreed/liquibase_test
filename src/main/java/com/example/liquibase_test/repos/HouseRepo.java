package com.example.liquibase_test.repos;

import com.example.liquibase_test.model.House;
import org.springframework.data.jpa.repository.EntityGraph;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.Optional;

/**
 * Created by MadThreeD on 2022.
 */

public interface HouseRepo extends JpaRepository<House, Long> {
//    @EntityGraph("house-with-windows")
//    @Override
//    Optional<House> findById(Long aLong);
}
