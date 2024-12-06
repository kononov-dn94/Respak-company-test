package com.example.respaktest.service;

import com.example.respaktest.entity.Computer;
import com.example.respaktest.entity.Television;
import com.example.respaktest.repository.TelevisionRepository;
import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.Collections;
import java.util.Comparator;
import java.util.List;
import java.util.stream.Collectors;

@Slf4j
@Service
public class TelevisionService {

    private final TelevisionRepository televisionRepository;

    public TelevisionService(TelevisionRepository televisionRepository) {
        this.televisionRepository = televisionRepository;
    }


    /**
     * Добавление нового Телевизора;
     *
     * @param television - информация о добавленной записи;
     */
    public void addTelevision(Television television) {
        televisionRepository.save(television);
    }

    /**
     * Сортировка Телевизоров по стоимости;
     *
     * @return - отсортированный список цен;
     */
    public ArrayList<Integer> sortTelevisionPrice() {
        List<Television> televisionList = televisionRepository.findAll();
        List<Integer> priceList = new ArrayList<>();
        if (!televisionList.isEmpty()) {
            for (Television television : televisionList) {
                priceList.add(television.getPrice());
            }
        }
        return priceList.stream().sorted(Comparator.reverseOrder()).collect(Collectors.toCollection(ArrayList::new));
    }

    /**
     * Сортировка Телевизоров по имени;
     *
     * @return - отсортированный список имен;
     */
    public List<String> sortTelevisionName() {
        List<Television> televisionList = televisionRepository.findAll();
        List<String> nameList = new ArrayList<>();
        if (!televisionList.isEmpty()) {
            for (Television television : televisionList) {
                nameList.add(television.getName());
            }
            Collections.sort(nameList, String.CASE_INSENSITIVE_ORDER);
        }
        return nameList;
    }

    /**
     * Сортировка всех записей Телевизоров по убыванию цены;
     *
     * @return - отсортированный список;
     */
    public List<Television> sortAllTelevisionByPrice() {
        return televisionRepository.findAllTelevisionOrderByPriceDesc();
    }

    /**
     * Сортировка всех записей Телевизоров по имени;
     *
     * @return - отсортированный список;
     */
    public List<Television> sortAllTelevisionByName() {
        return televisionRepository.findAllTelevisionOrderByNameDesc();
    }

    /**
     * Сортировка всех записей Телевизоров по цвету;
     *
     * @return - отсортированный список;
     */
    public List<Television> sortAllTelevisionByColor() {
        return televisionRepository.findAllTelevisionByColor();
    }

    /**
     * Сортировка всех записей Телевизоров по конкретному имени;
     *
     * @return - отсортированный список;
     */
    public List<Television> sortAllTelevisionLikeName() {
        return televisionRepository.findAllTelevisionByName();
    }
}
