package com.example.respaktest.repository;

import com.example.respaktest.entity.Smartphone;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;

import java.util.List;

public interface SmartphoneRepository extends JpaRepository<Smartphone, Long> {
    @Query(value = "SELECT * FROM smartphone order by price desc", nativeQuery = true)
    List<Smartphone> findAllSmartphoneOrderByPriceDesc();

    @Query(value = "SELECT * FROM smartphone order by name asc", nativeQuery = true)
    List<Smartphone> findAllSmartphoneOrderByNameDesc();

    @Query(value = "SELECT * FROM smartphone where color like 'black'", nativeQuery = true)
    List<Smartphone> findAllSmartphoneByColor();

    @Query(value = "SELECT * FROM smartphone where name like '%iaomi'", nativeQuery = true)
    List<Smartphone> findAllSmartphoneByName();
}
