package com.example.respaktest.repository;

import com.example.respaktest.entity.Computer;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;

import java.util.List;

public interface ComputerRepository extends JpaRepository<Computer, Long> {

    @Query(value = "SELECT * FROM computer order by price desc", nativeQuery = true)
    List<Computer> findAllComputerOrderByPriceDesc();

    @Query(value = "SELECT * FROM computer order by name asc", nativeQuery = true)
    List<Computer> findAllComputerOrderByNameDesc();

    @Query(value = "SELECT * FROM computer where color like 'red'", nativeQuery = true)
    List<Computer> findAllComputerByColor();

    @Query(value = "SELECT * FROM computer where name like '%pple'", nativeQuery = true)
    List<Computer> findAllComputerByName();
}

