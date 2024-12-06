package com.example.respaktest.repository;

import com.example.respaktest.entity.Fridge;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;

import java.util.List;

public interface FridgeRepository extends JpaRepository<Fridge, Long> {
    @Query(value = "SELECT * FROM fridge order by price desc", nativeQuery = true)
    List<Fridge> findAllFridgeOrderByPriceDesc();

    @Query(value = "SELECT * FROM fridge order by name asc", nativeQuery = true)
    List<Fridge> findAllFridgeOrderByNameDesc();

    @Query(value = "SELECT * FROM fridge where color like 'green'", nativeQuery = true)
    List<Fridge> findAllFridgeByColor();

    @Query(value = "SELECT * FROM fridge where name like '%eko'", nativeQuery = true)
    List<Fridge> findAllFridgeByName();
}
