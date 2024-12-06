package com.example.respaktest.entity;

import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;

@Data
@Entity
@Builder
@AllArgsConstructor
@Table(name = "VacuumCleaner")
public class VacuumCleaner {

    public VacuumCleaner() {}

    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private Long id;

    /**
     * Название;
     */
    @Column
    private String name;

    /**
     * Серийный номер;
     */
    @Column
    private String seriesNumber;

    /**
     * Цвет;
     */
    @Column
    private String color;

    /**
     * Размер;
     */
    @Column
    private Integer size;

    /**
     * Цена;
     */
    @Column
    private Integer price;

    /**
     * Обьем пылесборника;
     */
    @Column
    private Integer containerVolume;

    /**
     * Кол-во режимов;
     */
    @Column
    private Integer numberModes;

    /**
     * Наличие товара;
     * true - товар есть в наличии,
     * false - отсутствует;
     */
    @Column
    private Boolean availability;
}
