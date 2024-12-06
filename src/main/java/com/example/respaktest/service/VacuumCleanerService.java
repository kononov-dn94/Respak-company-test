package com.example.respaktest.service;

import com.example.respaktest.entity.VacuumCleaner;
import com.example.respaktest.repository.VacuumCleanerRepository;
import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.Collections;
import java.util.Comparator;
import java.util.List;
import java.util.stream.Collectors;

@Slf4j
@Service
public class VacuumCleanerService {

    private final VacuumCleanerRepository vacuumCleanerRepository;

    public VacuumCleanerService(VacuumCleanerRepository vacuumCleanerRepository) {
        this.vacuumCleanerRepository = vacuumCleanerRepository;
    }

    /**
     * Добавление нового Пылесоса;
     *
     * @param vacuumCleaner - информация о добавленной записи;
     */
    public void addVacuumCleaner(VacuumCleaner vacuumCleaner) {
        vacuumCleanerRepository.save(vacuumCleaner);
    }

    /**
     * Сортировка Пылесосов по стоимости;
     *
     * @return - отсортированный список цен;
     */
    public ArrayList<Integer> sortVacuumCleanerPrice() {
        List<VacuumCleaner> vacuumCleanerList = vacuumCleanerRepository.findAll();
        List<Integer> priceList = new ArrayList<>();
        if (!vacuumCleanerList.isEmpty()) {
            for (VacuumCleaner vacuumCleaner : vacuumCleanerList) {
                priceList.add(vacuumCleaner.getPrice());
            }
        }
        return priceList.stream().sorted(Comparator.reverseOrder()).collect(Collectors.toCollection(ArrayList::new));
    }

    /**
     * Сортировка Пылесосов по имени;
     *
     * @return - отсортированный список имен;
     */
    public List<String> sortVacuumCleanerName() {
        List<VacuumCleaner> vacuumCleanerList = vacuumCleanerRepository.findAll();
        List<String> nameList = new ArrayList<>();
        if (!vacuumCleanerList.isEmpty()) {
            for (VacuumCleaner vacuumCleaner : vacuumCleanerList) {
                nameList.add(vacuumCleaner.getName());
            }
            Collections.sort(nameList, String.CASE_INSENSITIVE_ORDER);
        }
        return nameList;
    }

    /**
     * Сортировка всех записей Пылесосов по убыванию цены;
     *
     * @return - отсортированный список;
     */
    public List<VacuumCleaner> sortAllVacuumCleanerByPrice() {
        return vacuumCleanerRepository.findAllVacuumCleanerOrderByPriceDesc();
    }

    /**
     * Сортировка всех записей Пылесосов по имени;
     *
     * @return - отсортированный список;
     */
    public List<VacuumCleaner> sortAllVacuumCleanerByName() {
        return vacuumCleanerRepository.findAllVacuumCleanerOrderByNameDesc();
    }

    /**
     * Сортировка всех записей Пылесосов по цвету;
     *
     * @return - отсортированный список;
     */
    public List<VacuumCleaner> sortAllVacuumCleanerByColor() {
        return vacuumCleanerRepository.findAllVacuumCleanerByColor();
    }

    /**
     * Сортировка всех записей Пылесосов по конкретному имени;
     *
     * @return - отсортированный список;
     */
    public List<VacuumCleaner> sortAllVacuumCleanerLikeName() {
        return vacuumCleanerRepository.findAllVacuumCleanerByName();
    }
}
