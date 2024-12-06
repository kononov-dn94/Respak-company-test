package com.example.respaktest.repository;

import com.example.respaktest.entity.VacuumCleaner;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;

import java.util.List;

public interface VacuumCleanerRepository extends JpaRepository<VacuumCleaner, Long> {
    @Query(value = "SELECT * FROM vacuum_cleaner order by price desc", nativeQuery = true)
    List<VacuumCleaner> findAllVacuumCleanerOrderByPriceDesc();

    @Query(value = "SELECT * FROM vacuum_cleaner order by name asc", nativeQuery = true)
    List<VacuumCleaner> findAllVacuumCleanerOrderByNameDesc();

    @Query(value = "SELECT * FROM vacuum_cleaner where color like 'red'", nativeQuery = true)
    List<VacuumCleaner> findAllVacuumCleanerByColor();

    @Query(value = "SELECT * FROM vacuum_cleaner where name like '%yson'", nativeQuery = true)
    List<VacuumCleaner> findAllVacuumCleanerByName();
}
