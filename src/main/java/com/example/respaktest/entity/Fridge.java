package com.example.respaktest.entity;

import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;

@Data
@Entity
@Builder
@AllArgsConstructor
@Table(name = "Fridge")
public class Fridge {

    public Fridge() {}

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
     * Кол-во дверей;
     */
    @Column
    private Integer doorsNumber;

    /**
     * Tип компрессора
     */
    @Column
    private String compressorType;

    /**
     * Наличие товара;
     * true - товар есть в наличии,
     * false - отсутствует;
     */
    @Column
    private Boolean availability;
}
