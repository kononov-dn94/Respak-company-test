package com.example.respaktest.service;

import com.example.respaktest.entity.Fridge;
import com.example.respaktest.repository.FridgeRepository;
import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.Collections;
import java.util.Comparator;
import java.util.List;
import java.util.stream.Collectors;

@Slf4j
@Service
public class FridgeService {

    private final FridgeRepository fridgeRepository;

    public FridgeService(FridgeRepository fridgeRepository) {
        this.fridgeRepository = fridgeRepository;
    }

    /**
     * Добавление нового Холодильника;
     *
     * @param fridge - информация о добавленной записи;
     */
    public void addFridge(Fridge fridge) {
        fridgeRepository.save(fridge);
    }

    /**
     * Сортировка Холодильников по стоимости;
     *
     * @return - отсортированный список цен;
     */
    public ArrayList<Integer> sortFridgePrice() {
        List<Fridge> fridgeList = fridgeRepository.findAll();
        List<Integer> priceList = new ArrayList<>();
        if (!fridgeList.isEmpty()) {
            for (Fridge fridge : fridgeList) {
                priceList.add(fridge.getPrice());
            }
        }
        return priceList.stream().sorted(Comparator.reverseOrder()).collect(Collectors.toCollection(ArrayList::new));
    }

    /**
     * Сортировка Холодильников по всем именам;
     *
     * @return - отсортированный список имен;
     */
    public List<String> sortFridgeName() {
        List<Fridge> fridgeList = fridgeRepository.findAll();
        List<String> nameList = new ArrayList<>();
        if (!fridgeList.isEmpty()) {
            for (Fridge fridge : fridgeList) {
                nameList.add(fridge.getName());
            }
            Collections.sort(nameList, String.CASE_INSENSITIVE_ORDER);
        }
        return nameList;
    }

    /**
     * Сортировка всех записей Холодильников по возрастанию цены;
     *
     * @return - отсортированный список;
     */
    public List<Fridge> sortAllFridgeByPrice() {
        return fridgeRepository.findAllFridgeOrderByPriceDesc();
    }

    /**
     * Сортировка всех Холодильников записей по имени;
     *
     * @return - отсортированный список;
     */
    public List<Fridge> sortAllFridgeByName() {
        return fridgeRepository.findAllFridgeOrderByNameDesc();
    }

    /**
     * Сортировка всех записей Холодильников по цвету;
     *
     * @return - отсортированный список;
     */
    public List<Fridge> sortAllFridgeByColor() {
        return fridgeRepository.findAllFridgeByColor();
    }

    /**
     * Сортировка всех записей Холодильников по конкретному имени;
     *
     * @return - отсортированный список;
     */
    public List<Fridge> sortAllFridgeLikeName() {
        return fridgeRepository.findAllFridgeByName();
    }
}
