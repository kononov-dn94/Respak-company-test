package com.example.respaktest.service;

import com.example.respaktest.entity.Computer;
import com.example.respaktest.repository.ComputerRepository;
import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.Collections;
import java.util.Comparator;
import java.util.List;
import java.util.stream.Collectors;

@Slf4j
@Service
public class ComputerService {

    private final ComputerRepository computerRepository;

    public ComputerService(ComputerRepository computerRepository) {
        this.computerRepository = computerRepository;
    }

    /**
     * Добавление нового Компьютера;
     *
     * @param computer - информация о добавленной записи;
     */
    public void addComputer(Computer computer) {
        computerRepository.save(computer);
    }

    /**
     * Сортировка Компьютеров по стоимости;
     *
     * @return - отсортированный список цен;
     */
    public ArrayList<Integer> sortComputerPrice() {
        List<Computer> computerList = computerRepository.findAll();
        List<Integer> priceList = new ArrayList<>();
        if (!computerList.isEmpty()) {
            for (Computer computer : computerList) {
                priceList.add(computer.getPrice());
            }
        }
        return priceList.stream().sorted(Comparator.reverseOrder()).collect(Collectors.toCollection(ArrayList::new));
    }

    /**
     * Сортировка Компьютеров по имени;
     *
     * @return - отсортированный список имен;
     */
    public List<String> sortComputerName() {
        List<Computer> computerList = computerRepository.findAll();
        List<String> nameList = new ArrayList<>();
        if (!computerList.isEmpty()) {
            for (Computer computer : computerList) {
                nameList.add(computer.getName());
            }
            Collections.sort(nameList, String.CASE_INSENSITIVE_ORDER);
        }
        return nameList;
    }

    /**
     * Сортировка всех записей Компьютеров по убыванию цены;
     *
     * @return - отсортированный список;
     */
    public List<Computer> sortAllComputerByPrice() {
        return computerRepository.findAllComputerOrderByPriceDesc();
    }

    /**
     * Сортировка всех записей Компьютеров по имени;
     *
     * @return - отсортированный список;
     */
    public List<Computer> sortFindAllComputerOrderByNameDesc() {
        return computerRepository.findAllComputerOrderByNameDesc();
    }

    /**
     * Сортировка всех записей Компьютеров по цвету;
     *
     * @return - отсортированный список;
     */
    public List<Computer> sortAllComputerByColor() {
        return computerRepository.findAllComputerByColor();
    }

    /**
     * Сортировка всех записей Компьютеров по конкретному имени;
     *
     * @return - отсортированный список;
     */
    public List<Computer> sortAllComputerByName() {
        return computerRepository.findAllComputerByName();
    }
}
