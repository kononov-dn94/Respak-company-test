package com.example.respaktest.controller;

import com.example.respaktest.dto.VacuumCleanerDTO;
import com.example.respaktest.entity.VacuumCleaner;
import com.example.respaktest.service.VacuumCleanerService;
import io.swagger.v3.oas.annotations.Operation;
import io.swagger.v3.oas.annotations.tags.Tag;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.ArrayList;
import java.util.List;

@Slf4j
@Tag(name = "vacuumCleaner")
@RequestMapping("/vacuumCleaner")
@RestController
public class VacuumCleanerController {

    @Autowired
    private final VacuumCleanerService vacuumCleanerService;

    public VacuumCleanerController(VacuumCleanerService vacuumCleanerService) {
        this.vacuumCleanerService = vacuumCleanerService;
    }

    /**
     * Добавление новой записи в таблицу VacuumCleaner;
     *
     * @param vacuumCleaner - информация о добавляемой записи;
     * @return - добавленный объект в JSON-формате;
     */
    @PostMapping("/add")
    @Operation(summary = "Добавление новой записи в таблицу VacuumCleaner",
            description = "Создание новой записи в таблице VacuumCleaner через переданный JSON-объект")
    public String addVacuumCleaner(@RequestBody VacuumCleanerDTO vacuumCleaner) {
        try {
            log.info("addVacuumCleaner: create new entry by vacuumCleaner");
            vacuumCleanerService.addVacuumCleaner(VacuumCleaner.builder()
                    .name(vacuumCleaner.getName())
                    .seriesNumber(vacuumCleaner.getSeriesNumber())
                    .color(vacuumCleaner.getColor())
                    .size(vacuumCleaner.getSize())
                    .price(vacuumCleaner.getPrice())
                    .containerVolume(vacuumCleaner.getContainerVolume())
                    .numberModes(vacuumCleaner.getNumberModes())
                    .availability(vacuumCleaner.getAvailability())
                    .build());
            return "New entry created " + vacuumCleaner;
        } catch (Exception e) {
            log.error("addVacuumCleaner: error {}", String.valueOf(e));
            return "addVacuumCleaner: error, check server logs";
        }
    }

    /**
     * Возврат отсортированного списка цен;
     *
     * @return - список цен по убыванию;
     */
    @GetMapping("/getSortVacuumCleanerPrice")
    @Operation(summary = "Отсортированный список цен Пылесосов",
            description = "Вернет список цен Пылесосов от большей к меньшей")
    public ArrayList<Integer> getSortVacuumCleanerPrice() {
        try {
            log.info("getSortVacuumCleanerPrice: info by priceVacuumCleaner");
            return vacuumCleanerService.sortVacuumCleanerPrice();
        } catch (Exception e) {
            log.error("getSortVacuumCleanerPrice: error {}", String.valueOf(e));
            return null;
        }
    }

    /**
     * Возврат отсортированного списка имен;
     *
     * @return - список имен в алфавитном порядке с учетом регистра;
     */
    @GetMapping("/getSortVacuumCleanerName")
    @Operation(summary = "Отсортированный список имен Пылесосов",
            description = "Вернет список имен Пылесосов в алфавитном порядке с учетом регистра")
    public List<String> getSortVacuumCleanerName() {
        try {
            log.info("getSortComputerName: info by sortName");
            return vacuumCleanerService.sortVacuumCleanerName();
        } catch (Exception e) {
            log.error("getSortComputerName: error {}", String.valueOf(e));
            return null;
        }
    }

    /**
     * Возврат отсортированного Пылесосов по цене;
     *
     * @return - список Компьютеров по убыванию цены;
     */
    @GetMapping("/getSortAllVacuumCleanerByPrice")
    @Operation(summary = "Отсортированный список Пылесосов по цене",
            description = "Вернет список Пылесосов в виде JSON-объектов по убыванию цены")
    public List<VacuumCleaner> getSortAllVacuumCleanerByPrice() {
        try {
            log.info("getSortAllVacuumCleanerByPrice: info by sort all vacuumCleaner price");
            return vacuumCleanerService.sortAllVacuumCleanerByPrice();
        } catch (Exception e) {
            log.error("getSortAllVacuumCleanerByPrice: error {}", String.valueOf(e));
            return null;
        }
    }

    /**
     * Возврат отсортированного Пылесосов по имени;
     *
     * @return - список Компьютеров по имени;
     */
    @GetMapping("/getSortAllVacuumCleanerByName")
    @Operation(summary = "Отсортированный список Пылесосов по имени в алфавитном порядке",
            description = "Вернет список Пылесосов в виде JSON-объектов по имени в алфавитном порядке")
    public List<VacuumCleaner> getSortAllVacuumCleanerByName() {
        try {
            log.info("getSortAllVacuumCleanerByName: info by sort all vacuumCleaner name");
            return vacuumCleanerService.sortAllVacuumCleanerByName();
        } catch (Exception e) {
            log.error("getSortAllVacuumCleanerByName: error {}", String.valueOf(e));
            return null;
        }
    }

    /**
     * Возврат списка Пылесосов по определенному цвету;
     *
     * @return - список Пылесосов по определенному цвету;
     */
    @GetMapping("/getSortAllVacuumCleanerByColor")
    @Operation(summary = "Отсортированный список Пылесосов по конкретному цвету",
            description = "Вернет список Пылесосов в виде JSON-объектов по заданному цвету")
    public List<VacuumCleaner> getSortAllVacuumCleanerByColor() {
        try {
            log.info("getSortAllVacuumCleanerByColor: info by sort all vacuumCleaner by color");
            return vacuumCleanerService.sortAllVacuumCleanerByColor();
        } catch (Exception e) {
            log.error("getSortAllVacuumCleanerByColor: error {}", String.valueOf(e));
            return null;
        }
    }

    /**
     * Возврат списка Пылесосов по определенному имени;
     *
     * @return - список Пылесосов по определенному имени;
     */
    @GetMapping("/getSortAllVacuumCleanerLikeName")
    @Operation(summary = "Отсортированный список Пылесосов по конкретному имени",
            description = "Вернет список Пылесосов в виде JSON-объектов по искомому имени")
    public List<VacuumCleaner> getSortAllVacuumCleanerLikeName() {
        try {
            log.info("getSortAllVacuumCleanerLikeName: info by sort all vacuumCleaner by like name");
            return vacuumCleanerService.sortAllVacuumCleanerLikeName();
        } catch (Exception e) {
            log.error("getSortAllVacuumCleanerLikeName: error {}", String.valueOf(e));
            return null;
        }
    }
}
