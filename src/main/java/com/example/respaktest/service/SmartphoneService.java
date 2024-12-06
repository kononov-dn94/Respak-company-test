package com.example.respaktest.service;

import com.example.respaktest.entity.Smartphone;
import com.example.respaktest.repository.SmartphoneRepository;
import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.Collections;
import java.util.Comparator;
import java.util.List;
import java.util.stream.Collectors;

@Slf4j
@Service
public class SmartphoneService {

    private final SmartphoneRepository smartphoneRepository;

    public SmartphoneService(SmartphoneRepository smartphoneRepository) {
        this.smartphoneRepository = smartphoneRepository;
    }

    /**
     * Добавление нового Смартфона;
     *
     * @param smartphone - информация о добавленной записи;
     */
    public void addSmartphone(Smartphone smartphone) {
        smartphoneRepository.save(smartphone);
    }

    /**
     * Сортировка Смартфонов по стоимости;
     *
     * @return - отсортированный список цен;
     */
    public ArrayList<Integer> sortSmartphonePrice() {
        List<Smartphone> smartphoneList = smartphoneRepository.findAll();
        List<Integer> priceList = new ArrayList<>();
        if (!smartphoneList.isEmpty()) {
            for (Smartphone smartphone : smartphoneList) {
                priceList.add(smartphone.getPrice());
            }
        }
        return priceList.stream().sorted(Comparator.reverseOrder()).collect(Collectors.toCollection(ArrayList::new));
    }

    /**
     * Сортировка Смартфонов по имени;
     *
     * @return - отсортированный список имен;
     */
    public List<String> sortSmartphoneName() {
        List<Smartphone> smartphoneList = smartphoneRepository.findAll();
        List<String> nameList = new ArrayList<>();
        if (!smartphoneList.isEmpty()) {
            for (Smartphone smartphone : smartphoneList) {
                nameList.add(smartphone.getName());
            }
            Collections.sort(nameList, String.CASE_INSENSITIVE_ORDER);
        }
        return nameList;
    }

    /**
     * Сортировка всех записей Смартфонов по убыванию цены;
     *
     * @return - отсортированный список;
     */
    public List<Smartphone> sortAllSmartphoneByPrice() {
        return smartphoneRepository.findAllSmartphoneOrderByPriceDesc();
    }

    /**
     * Сортировка всех записей Смартфонов по имени;
     *
     * @return - отсортированный список;
     */
    public List<Smartphone> sortAllSmartphoneByName() {
        return smartphoneRepository.findAllSmartphoneOrderByNameDesc();
    }

    /**
     * Сортировка всех записей Смартфонов по цвету;
     *
     * @return - отсортированный список;
     */
    public List<Smartphone> sortAllSmartphoneByColor() {
        return smartphoneRepository.findAllSmartphoneByColor();
    }

    /**
     * Сортировка всех записей Смартфонов по конкретному имени;
     *
     * @return - отсортированный список;
     */
    public List<Smartphone> sortAllSmartphoneLikeName() {
        return smartphoneRepository.findAllSmartphoneByName();
    }
}
