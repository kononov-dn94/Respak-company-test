package com.example.respaktest.repository;

import com.example.respaktest.entity.Television;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;

import java.util.List;

public interface TelevisionRepository extends JpaRepository<Television, Long> {
    @Query(value = "SELECT * FROM television order by price desc", nativeQuery = true)
    List<Television> findAllTelevisionOrderByPriceDesc();

    @Query(value = "SELECT * FROM television order by name asc", nativeQuery = true)
    List<Television> findAllTelevisionOrderByNameDesc();

    @Query(value = "SELECT * FROM television where color like 'white'", nativeQuery = true)
    List<Television> findAllTelevisionByColor();

    @Query(value = "SELECT * FROM television where name like 'L%'", nativeQuery = true)
    List<Television> findAllTelevisionByName();
}
