package com.example.respaktest.entity;

import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;

@Data
@Entity
@Builder
@AllArgsConstructor
@Table(name = "Smartphone")
public class Smartphone {

    public Smartphone() {}

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
     * Размер памяти;
     */
    @Column
    private Integer memory;

    /**
     * Кол-во камер;
     */
    @Column
    private Integer camerasNumber;

    /**
     * Наличие товара;
     * true - товар есть в наличии,
     * false - отсутствует;
     */
    @Column
    private Boolean availability;
}
