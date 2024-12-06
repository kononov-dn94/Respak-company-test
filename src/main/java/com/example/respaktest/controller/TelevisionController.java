package com.example.respaktest.controller;

import com.example.respaktest.dto.TelevisionDTO;
import com.example.respaktest.entity.Television;
import com.example.respaktest.service.TelevisionService;
import io.swagger.v3.oas.annotations.Operation;
import io.swagger.v3.oas.annotations.tags.Tag;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.ArrayList;
import java.util.List;

@Slf4j
@Tag(name = "television")
@RequestMapping("/television")
@RestController
public class TelevisionController {

    @Autowired
    private final TelevisionService televisionService;

    public TelevisionController(TelevisionService televisionService) {
        this.televisionService = televisionService;
    }

    /**
     * Добавление новой записи в таблицу Television;
     *
     * @param television - информация о добавляемой записи;
     * @return - добавленный объект в JSON-формате;
     */
    @PostMapping("/add")
    @Operation(summary = "Добавление новой записи в таблицу Television",
            description = "Создание новой записи в таблице Television через переданный JSON-объект")
    public String addTelevision(@RequestBody TelevisionDTO television) {
        try {
            log.info("addTelevision: create new entry by television");
            televisionService.addTelevision(Television.builder()
                    .name(television.getName())
                    .seriesNumber(television.getSeriesNumber())
                    .color(television.getColor())
                    .size(television.getSize())
                    .price(television.getPrice())
                    .category(television.getCategory())
                    .technology(television.getTechnology())
                    .availability(television.getAvailability())
                    .build());
            return "New entry created " + television;
        } catch (Exception e) {
            log.error("addTelevision: error {}", String.valueOf(e));
            return "addTelevision: error, check server logs";
        }
    }

    /**
     * Возврат отсортированного списка цен;
     *
     * @return - список цен по убыванию;
     */
    @GetMapping("/getSortTelevisionPrice")
    @Operation(summary = "Отсортированный список цен Телевизоров",
            description = "Вернет список цен Телевизоров от большей к меньшей")
    public ArrayList<Integer> getSortTelevisionPrice() {
        try {
            log.info("getSortTelevisionPrice: info by price Television");
            return televisionService.sortTelevisionPrice();
        } catch (Exception e) {
            log.error("getSortTelevisionPrice: error {}", String.valueOf(e));
            return null;
        }
    }

    /**
     * Возврат отсортированного списка имен;
     *
     * @return - список имен в алфавитном порядке с учетом регистра;
     */
    @GetMapping("/getSortTelevisionName")
    @Operation(summary = "Отсортированный список имен Телевизоров",
            description = "Вернет список имен Телевизоров в алфавитном порядке с учетом регистра")
    public List<String> getSortTelevisionName() {
        try {
            log.info("getSortTelevisionName: info by sortName");
            return televisionService.sortTelevisionName();
        } catch (Exception e) {
            log.error("getSortTelevisionName: error {}", String.valueOf(e));
            return null;
        }
    }

    /**
     * Возврат отсортированного Телевизоров по цене;
     *
     * @return - список Компьютеров по убыванию цены;
     */
    @GetMapping("/getSortAllTelevisionByPrice")
    @Operation(summary = "Отсортированный список Телевизоров по цене",
            description = "Вернет список Телевизоров в виде JSON-объектов по убыванию цены")
    public List<Television> getSortAllTelevisionByPrice() {
        try {
            log.info("getSortAllTelevisionByPrice: info by sort all television price");
            return televisionService.sortAllTelevisionByPrice();
        } catch (Exception e) {
            log.error("getSortAllTelevisionByPrice: error {}", String.valueOf(e));
            return null;
        }
    }

    /**
     * Возврат отсортированного Телевизоров по имени;
     *
     * @return - список Компьютеров по имени;
     */
    @GetMapping("/getSortAllTelevisionByName")
    @Operation(summary = "Отсортированный список Телевизоров по имени в алфавитном порядке",
            description = "Вернет список Телевизоров в виде JSON-объектов по имени в алфавитном порядке")
    public List<Television> getSortAllTelevisionByName() {
        try {
            log.info("getSortAllTelevisionByName: info by sort all television name");
            return televisionService.sortAllTelevisionByName();
        } catch (Exception e) {
            log.error("getSortAllTelevisionByName: error {}", String.valueOf(e));
            return null;
        }
    }

    /**
     * Возврат списка Телевизоров по определенному цвету;
     *
     * @return - список Телевизоров по определенному цвету;
     */
    @GetMapping("/getSortAllTelevisionByColor")
    @Operation(summary = "Отсортированный список Телевизоров по конкретному цвету",
            description = "Вернет список Телевизоров в виде JSON-объектов по заданному цвету")
    public List<Television> getSortAllTelevisionByColor() {
        try {
            log.info("getSortAllTelevisionByColor: info by sort all television by color");
            return televisionService.sortAllTelevisionByColor();
        } catch (Exception e) {
            log.error("getSortAllTelevisionByColor: error {}", String.valueOf(e));
            return null;
        }
    }

    /**
     * Возврат списка Телевизоров по определенному имени;
     *
     * @return - список Телевизоров по определенному имени;
     */
    @GetMapping("/getSortAllTelevisionLikeName")
    @Operation(summary = "Отсортированный список Телевизоров по конкретному имени",
            description = "Вернет список Телевизоров в виде JSON-объектов по искомому имени")
    public List<Television> getSortAllTelevisionLikeName() {
        try {
            log.info("getSortAllTelevisionLikeName: info by sort all television by like name");
            return televisionService.sortAllTelevisionLikeName();
        } catch (Exception e) {
            log.error("getSortAllTelevisionLikeName: error {}", String.valueOf(e));
            return null;
        }
    }
}
