package com.example.respaktest.controller;

import com.example.respaktest.dto.ComputerDTO;
import com.example.respaktest.entity.Computer;
import com.example.respaktest.service.ComputerService;
import io.swagger.v3.oas.annotations.Operation;
import io.swagger.v3.oas.annotations.tags.Tag;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.ArrayList;
import java.util.List;

@Slf4j
@Tag(name = "computer")
@RequestMapping("/computer")
@RestController
public class ComputerController {

    @Autowired
    private final ComputerService computerService;

    public ComputerController(ComputerService computerService) {
        this.computerService = computerService;
    }

    /**
     * Добавление новой записи в таблицу Computer;
     *
     * @param computer - информация о добавляемой записи;
     */
    @PostMapping("/add")
    @Operation(summary = "Добавление новой записи в таблицу Computer",
            description = "Создание новой записи в таблице Computer через переданный JSON-объект")
    public String addComputer(@RequestBody ComputerDTO computer) {
        try {
            log.info("addComputer: create new entry by computer");
            computerService.addComputer(Computer.builder()
                    .name(computer.getName())
                    .seriesNumber(computer.getSeriesNumber())
                    .color(computer.getColor())
                    .size(computer.getSize())
                    .price(computer.getPrice())
                    .category(computer.getCategory())
                    .processorType(computer.getProcessorType())
                    .availability(computer.getAvailability())
                    .build());

            return "New entry created " + computer;
        } catch (Exception e) {
            log.error("addComputer: error {}", String.valueOf(e));
            return "ComputerController: error, check server logs";
        }
    }

    /**
     * Возврат отсортированного списка цен;
     *
     * @return - список цен по убыванию;
     */
    @GetMapping("/getSortComputerPrice")
    @Operation(summary = "Отсортированный список цен Компьютеров",
            description = "Вернет список цен Компьютеров от большей к меньшей")
    public ArrayList<Integer> getSortComputerPrice() {
        try {
            log.info("getSortComputerPrice: info by priceComputer");
            return computerService.sortComputerPrice();
        } catch (Exception e) {
            log.error("getSortComputerPrice: error {}", String.valueOf(e));
            return null;
        }
    }

    /**
     * Возврат отсортированного списка имен;
     *
     * @return - список имен в алфавитном порядке с учетом регистра;
     */
    @GetMapping("/getSortComputerName")
    @Operation(summary = "Отсортированный список имен Компьютеров",
            description = "Вернет список имен Компьютеров в алфавитном порядке с учетом регистра")
    public List<String> getSortComputerName() {
        try {
            log.info("getSortComputerName: info by sortName");
            return computerService.sortComputerName();
        } catch (Exception e) {
            log.error("getSortComputerName: error {}", String.valueOf(e));
            return null;
        }
    }

    /**
     * Возврат отсортированного списка Компьютеров по цене;
     *
     * @return - список Компьютеров по убыванию цены;
     */
    @GetMapping("/getSortAllComputerByPrice")
    @Operation(summary = "Отсортированный список Компьютеров по цене",
            description = "Вернет список Компьютеров в виде JSON-объектов по убыванию цены")
    public List<Computer> getSortAllComputerByPrice() {
        try {
            log.info("getSortAllComputerByPrice: info by sort all computer price");
            return computerService.sortAllComputerByPrice();
        } catch (Exception e) {
            log.error("getSortAllComputerByPrice: error {}", String.valueOf(e));
            return null;
        }
    }

    /**
     * Возврат отсортированного Компьютеров по имени;
     *
     * @return - список Компьютеров по имени;
     */
    @GetMapping("/getSortAllComputerByName")
    @Operation(summary = "Отсортированный список Компьютеров по имени в алфавитном порядке",
            description = "Вернет список Компьютеров в виде JSON-объектов по имени в алфавитном порядке")
    public List<Computer> getSortAllComputerByName() {
        try {
            log.info("getSortAllComputerByName: info by sort all computer name");
            return computerService.sortFindAllComputerOrderByNameDesc();
        } catch (Exception e) {
            log.error("getSortAllComputerByName: error {}", String.valueOf(e));
            return null;
        }
    }

    /**
     * Возврат списка Компьютеров по определенному цвету;
     *
     * @return - список Компьютеров по определенному цвету;
     */
    @GetMapping("/getSortAllComputerByColor")
    @Operation(summary = "Отсортированный список Компьютеров по конкретному цвету",
            description = "Вернет список Компьютеров в виде JSON-объектов по заданному цвету")
    public List<Computer> getSortAllComputerByColor() {
        try {
            log.info("getSortAllComputerByColor: info by sort all computer by color");
            return computerService.sortAllComputerByColor();
        } catch (Exception e) {
            log.error("getSortAllComputerByColor: error {}", String.valueOf(e));
            return null;
        }
    }

    /**
     * Возврат списка Компьютеров по определенному имени;
     *
     * @return - список Компьютеров по определенному имени;
     */
    @GetMapping("/getSortAllComputerLikeName")
    @Operation(summary = "Отсортированный список Компьютеров по конкретному имени",
            description = "Вернет список Компьютеров в виде JSON-объектов по искомому имени")
    public List<Computer> getSortAllComputerLikeName() {
        try {
            log.info("getSortAllComputerLikeName: info by sort all computer by like name");
            return computerService.sortAllComputerByName();
        } catch (Exception e) {
            log.error("getSortAllComputerLikeName: error {}", String.valueOf(e));
            return null;
        }
    }
}