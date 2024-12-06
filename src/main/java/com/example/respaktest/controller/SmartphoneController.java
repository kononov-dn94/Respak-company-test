package com.example.respaktest.controller;

import com.example.respaktest.dto.SmartphoneDTO;
import com.example.respaktest.entity.Smartphone;
import com.example.respaktest.service.SmartphoneService;
import io.swagger.v3.oas.annotations.Operation;
import io.swagger.v3.oas.annotations.tags.Tag;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.ArrayList;
import java.util.List;

@Slf4j
@Tag(name = "smartphone")
@RequestMapping("/smartphone")
@RestController
public class SmartphoneController {

    @Autowired
    private final SmartphoneService smartphoneService;

    public SmartphoneController(SmartphoneService smartphoneService) {
        this.smartphoneService = smartphoneService;
    }

    /**
     * Добавление новой записи в таблицу Smartphone;
     *
     * @param smartphone - информация о добавляемой записи;
     * @return - добавленный объект в JSON-формате;
     */
    @PostMapping("/add")
    @Operation(summary = "Добавление новой записи в таблицу Smartphone",
            description = "Создание новой записи в таблице Smartphone через переданный JSON-объект")
    public String addSmartphone(@RequestBody SmartphoneDTO smartphone) {
        try {
            log.info("addSmartphone: create new entry by smartphone");
            smartphoneService.addSmartphone(Smartphone.builder()
                    .name(smartphone.getName())
                    .seriesNumber(smartphone.getSeriesNumber())
                    .color(smartphone.getColor())
                    .size(smartphone.getSize())
                    .price(smartphone.getPrice())
                    .memory(smartphone.getMemory())
                    .camerasNumber(smartphone.getCamerasNumber())
                    .availability(smartphone.getAvailability())
                    .build());
            return "New entry created " + smartphone;
        } catch (Exception e) {
            log.error("addSmartphone: error {}", String.valueOf(e));
            return "addSmartphone: error, check server logs";
        }
    }

    /**
     * Возврат отсортированного списка цен;
     *
     * @return - список цен по убыванию;
     */
    @GetMapping("/getSortSmartphonePrice")
    @Operation(summary = "Отсортированный список цен Смартфонов",
            description = "Вернет список цен Смартфонов от большей к меньшей")
    public ArrayList<Integer> getSortSmartphonePrice() {
        try {
            log.info("getSortSmartphonePrice: info by price smartphone");
            return smartphoneService.sortSmartphonePrice();
        } catch (Exception e) {
            log.error("getSortSmartphonePrice: error {}", String.valueOf(e));
            return null;
        }
    }

    /**
     * Возврат отсортированного списка имен;
     *
     * @return - список имен в алфавитном порядке с учетом регистра;
     */
    @GetMapping("/getSortSmartphoneName")
    @Operation(summary = "Отсортированный список имен Смартфонов",
            description = "Вернет список имен Смартфонов в алфавитном порядке с учетом регистра")
    public List<String> getSortSmartphoneName() {
        try {
            log.info("getSortSmartphoneName: info by sortName");
            return smartphoneService.sortSmartphoneName();
        } catch (Exception e) {
            log.error("getSortSmartphoneName: error {}", String.valueOf(e));
            return null;
        }
    }

    /**
     * Возврат отсортированного Смартфонов по цене;
     *
     * @return - список Смартфонов по убыванию цены;
     */
    @GetMapping("/getSortAllSmartphoneByPrice")
    @Operation(summary = "Отсортированный список Смартфонов по цене",
            description = "Вернет список Смартфонов в виде JSON-объектов по убыванию цены")
    public List<Smartphone> getSortAllSmartphoneByPrice() {
        try {
            log.info("getSortAllSmartphoneByPrice: info by sort all smartphone price");
            return smartphoneService.sortAllSmartphoneByPrice();
        } catch (Exception e) {
            log.error("getSortAllSmartphoneByPrice: error {}", String.valueOf(e));
            return null;
        }
    }

    /**
     * Возврат отсортированного списка Смартфонов по имени;
     *
     * @return - список Компьютеров по имени;
     */
    @GetMapping("/getSortAllSmartphoneByName")
    @Operation(summary = "Отсортированный список Смартфонов по имени в алфавитном порядке",
            description = "Вернет список Смартфонов в виде JSON-объектов по имени в алфавитном порядке")
    public List<Smartphone> getSortAllSmartphoneByName() {
        try {
            log.info("getSortAllSmartphoneByName: info by sort all smartphone name");
            return smartphoneService.sortAllSmartphoneByName();
        } catch (Exception e) {
            log.error("getSortAllSmartphoneByName: error {}", String.valueOf(e));
            return null;
        }
    }

    /**
     * Возврат списка Смартфонов по определенному цвету;
     *
     * @return - список Смартфонов по определенному цвету;
     */
    @GetMapping("/getSortAllSmartphoneByColor")
    @Operation(summary = "Отсортированный список Смартфонов по конкретному цвету",
            description = "Вернет список Смартфонов в виде JSON-объектов по заданному цвету")
    public List<Smartphone> getSortAllSmartphoneByColor() {
        try {
            log.info("getSortAllSmartphoneByColor: info by sort all smartphone by color");
            return smartphoneService.sortAllSmartphoneByColor();
        } catch (Exception e) {
            log.error("getSortAllSmartphoneByColor: error {}", String.valueOf(e));
            return null;
        }
    }

    /**
     * Возврат списка Смартфонов по определенному имени;
     *
     * @return - список Смартфонов по определенному имени;
     */
    @GetMapping("/getSortAllSmartphoneLikeName")
    @Operation(summary = "Отсортированный список Смартфонов по конкретному имени",
            description = "Вернет список Смартфонов в виде JSON-объектов по искомому имени")
    public List<Smartphone> getSortAllSmartphoneLikeName() {
        try {
            log.info("getSortAllSmartphoneLikeName: info by sort all smartphone by like name");
            return smartphoneService.sortAllSmartphoneLikeName();
        } catch (Exception e) {
            log.error("getSortAllSmartphoneLikeName: error {}", String.valueOf(e));
            return null;
        }
    }
}
