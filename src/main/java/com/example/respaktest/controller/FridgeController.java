package com.example.respaktest.controller;

import com.example.respaktest.dto.FridgeDTO;
import com.example.respaktest.entity.Fridge;
import com.example.respaktest.service.FridgeService;
import io.swagger.v3.oas.annotations.Operation;
import io.swagger.v3.oas.annotations.tags.Tag;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.ArrayList;
import java.util.List;

@Slf4j
@Tag(name = "fridge")
@RequestMapping("/fridge")
@RestController
public class FridgeController {

    @Autowired
    private final FridgeService fridgeService;

    public FridgeController(FridgeService fridgeService) {
        this.fridgeService = fridgeService;
    }

    /**
     * Добавление новой записи в таблицу Fridge;
     *
     * @param fridge - информация о добавляемой записи;
     */
    @PostMapping("/add")
    @Operation(summary = "Добавление новой записи в таблицу Fridge",
            description = "Создание новой записи в таблице Fridge через переданный JSON-объект")
    public String addFridge(@RequestBody FridgeDTO fridge) {
        try {
            log.info("addFridge: create new entry by fridge");
            fridgeService.addFridge(Fridge.builder()
                    .name(fridge.getName())
                    .seriesNumber(fridge.getSeriesNumber())
                    .color(fridge.getColor())
                    .size(fridge.getSize())
                    .price(fridge.getPrice())
                    .doorsNumber(fridge.getDoorsNumber())
                    .compressorType(fridge.getCompressorType())
                    .availability(fridge.getAvailability())
                    .build());
            return "New entry created " + fridge;
        } catch (Exception e) {
            log.error("addFridge: error {}", String.valueOf(e));
            return "addFridge: error, check server logs";
        }
    }

    /**
     * Возврат отсортированного списка цен;
     *
     * @return - список цен по убыванию;
     */
    @GetMapping("/getSortFridgePrice")
    @Operation(summary = "Отсортированный список цен Холодильников",
            description = "Вернет список цен Холодильников от большей к меньшей")
    public ArrayList<Integer> getSortFridgePrice() {
        try {
            log.info("getSortFridgePrice: info by price fridge");
            return fridgeService.sortFridgePrice();
        } catch (Exception e) {
            log.error("getSortFridgePrice: error {}", String.valueOf(e));
            return null;
        }
    }

    /**
     * Возврат отсортированного списка имен;
     *
     * @return - список имен в алфавитном порядке с учетом регистра;
     */
    @GetMapping("/getSortFridgeName")
    @Operation(summary = "Отсортированный список имен Холодильников",
            description = "Вернет список имен Холодильников в алфавитном порядке с учетом регистра")
    public List<String> getSortFridgeName() {
        try {
            log.info("getSortComputerName: info by sortName");
            return fridgeService.sortFridgeName();
        } catch (Exception e) {
            log.error("getSortComputerName: error {}", String.valueOf(e));
            return null;
        }
    }

    /**
     * Возврат отсортированного Холодильников по цене;
     *
     * @return - список Холодильников по убыванию цены;
     */
    @GetMapping("/getSortAllFridgeByPrice")
    @Operation(summary = "Отсортированный список Холодильников по цене",
            description = "Вернет список Холодильников в виде JSON-объектов по убыванию цены")
    public List<Fridge> getSortAllFridgeByPrice() {
        try {
            log.info("getSortAllFridgeByPrice: info by sort all fridge price");
            return fridgeService.sortAllFridgeByPrice();
        } catch (Exception e) {
            log.error("getSortAllFridgeByPrice: error {}", String.valueOf(e));
            return null;
        }
    }

    /**
     * Возврат отсортированного Холодильников по имени;
     *
     * @return - список Холодильников по имени;
     */
    @GetMapping("/getSortAllFridgeByName")
    @Operation(summary = "Отсортированный список Холодильников по имени в алфавитном порядке",
            description = "Вернет список Холодильников в виде JSON-объектов по имени в алфавитном порядке")
    public List<Fridge> getSortAllFridgeByName() {
        try {
            log.info("getSortAllFridgeByName: info by sort all fridge name");
            return fridgeService.sortAllFridgeByName();
        } catch (Exception e) {
            log.error("getSortAllFridgeByName: error {}", String.valueOf(e));
            return null;
        }
    }

    /**
     * Возврат списка Холодильников по определенному цвету;
     *
     * @return - список Холодильников по определенному цвету;
     */
    @GetMapping("/getSortAllFridgeByColor")
    @Operation(summary = "Отсортированный список Холодильников по конкретному цвету",
            description = "Вернет список Холодильников в виде JSON-объектов по заданному цвету")
    public List<Fridge> getSortAllFridgeByColor() {
        try {
            log.info("getSortAllFridgeByColor: info by sort all fridge by color");
            return fridgeService.sortAllFridgeByColor();
        } catch (Exception e) {
            log.error("getSortAllFridgeByColor: error {}", String.valueOf(e));
            return null;
        }
    }

    /**
     * Возврат списка Холодильников по определенному имени;
     *
     * @return - список Холодильников по определенному имени;
     */
    @GetMapping("/getSortAllFridgeLikeName")
    @Operation(summary = "Отсортированный список Холодильников по конкретному имени",
            description = "Вернет список Холодильников в виде JSON-объектов по искомому имени")
    public List<Fridge> getSortAllFridgeLikeName() {
        try {
            log.info("getSortAllFridgeLikeName: info by sort all fridge by like name");
            return fridgeService.sortAllFridgeLikeName();
        } catch (Exception e) {
            log.error("getSortAllFridgeLikeName: error {}", String.valueOf(e));
            return null;
        }
    }
}
