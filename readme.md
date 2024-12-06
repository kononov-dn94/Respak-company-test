# Electronics Store

Реализовал:
- Кононов Дмитрий Николаевич
- kononov-dn94@yandex.ru

### Тестовое задание для java-разработчика в компанию RESPAK:
- Реализовать модели телевизоры, пылесосы, холодильники, смартфоны и компьютеры;
- Задать моделям поля. указанные в требованиях;
- Реализовать для каждый модели методы-контроллеры, по которым будут:
  - Добавляться новые записи;
  - Сортировка только по ценам от большей к меньшей;
  - Сортировка по именам в алфавитном порядке с учетом регистра;
  - Сорировка всех записей модели по убыванию цены;
  - Сорировка всех записей модели по имени;
  - Сортировка по цвету;
  - Сортировка по конкретному имени;

### Используемые технологии
- [PostgreSQL] -  свободная объектно-реляционная система управления базами данных (СУБД);
- [Java] - объектно-ориентированный язык программирования;
- [Spring] - универсальный фреймворк с открытым исходным кодом для Java-платформы;
- [Swagger] - инструмент, для создавания, документированияи проверяки API;
- [Postman] - интерфейс, для тестирования API;

### Ссылка на read-страницу Swagger:
```sh
http://localhost:8081/swagger-ui/index.html#/
```

### Инструкция по запуску
- В программе pgAdmin 4 на сервере localhost создать таблицу Respak-test указав креды доступа к БД указанных в  файле **application.properties**;
- Запустить java-приложение;

Далее, описываю логику работы приложения на примере таблицы Computer:
- С помощью **Postman** создаем реквест на добавление новой записи в таблицу Computer указав нужный реквест:
```sh
localhost:8081/computer/add
```
- В самом **Postman** в созданном реквесте указываем новую добавляемую сущность в виде JSON-обьекта:
```sh
{
    "name": "Apple",
    "seriesNumber": "WLX20360E1",
    "color": "white",
    "size": 30,
    "price": 150000,
    "category": "work",
    "processorType": "CPU",
    "availability": true
}
```
После добавления достаточного количесва сущностей, можно проверять сортировки по нужным нам признакам.
- Отсортированный список цен Компьютеров:
```sh
localhost:8081/computer/getSortComputerPrice
```
- Результат запроса:
```sh
[
    200000,
    150000,
    150000,
    120000,
    110000,
    90000,
    50000
]
```

- Отсортированный список имен Компьютеров:
```sh
localhost:8081/computer/getSortComputerName
```
- Результат запроса:
```sh
[
    "Acer",
    "Apple",
    "apple",
    "H",
    "Lenovo",
    "MSI",
    "Samsung"
]
```

- Отсортированный список Компьютеров по цене:
```sh
localhost:8081/computer/getSortAllComputerByPrice
```
- Результат запроса:
```sh
[
    {
        "id": 302,
        "name": "H",
        "seriesNumber": "12FHEWFHB377FHFWHF",
        "color": "blue",
        "size": 25,
        "price": 200000,
        "category": "person",
        "processorType": "CPU",
        "availability": true
    },
    {
        "id": 1,
        "name": "Apple",
        "seriesNumber": "WLX20360E1",
        "color": "white",
        "size": 30,
        "price": 150000,
        "category": "work",
        "processorType": "CPU",
        "availability": true
    },
    {
        "id": 253,
        "name": "apple",
        "seriesNumber": "JRTERQQ12FEW2",
        "color": "red",
        "size": 38,
        "price": 150000,
        "category": "work",
        "processorType": "CPU",
        "availability": true
    },
    {
        "id": 2,
        "name": "Acer",
        "seriesNumber": "EWFW2WGEDS0I22",
        "color": "white",
        "size": 45,
        "price": 120000,
        "category": "work",
        "processorType": "CPU",
        "availability": true
    },
    {
        "id": 3,
        "name": "Samsung",
        "seriesNumber": "WWDFG234HDF45",
        "color": "white",
        "size": 30,
        "price": 110000,
        "category": "work",
        "processorType": "CPU",
        "availability": true
    },
    {
        "id": 252,
        "name": "Lenovo",
        "seriesNumber": "TGTRHGTR000W7447",
        "color": "red",
        "size": 38,
        "price": 90000,
        "category": "work",
        "processorType": "CPU",
        "availability": true
    },
    {
        "id": 254,
        "name": "MSI",
        "seriesNumber": "WEGWERGWJUUJUZZ",
        "color": "red",
        "size": 38,
        "price": 50000,
        "category": "work",
        "processorType": "CPU",
        "availability": true
    }
]
```

- Отсортированный список Компьютеров по имени в алфавитном порядке:
```sh
localhost:8081/computer/getSortAllComputerByName
```
- Результат запроса:
```sh
[
    {
        "id": 2,
        "name": "Acer",
        "seriesNumber": "EWFW2WGEDS0I22",
        "color": "white",
        "size": 45,
        "price": 120000,
        "category": "work",
        "processorType": "CPU",
        "availability": true
    },
    {
        "id": 253,
        "name": "apple",
        "seriesNumber": "JRTERQQ12FEW2",
        "color": "red",
        "size": 38,
        "price": 150000,
        "category": "work",
        "processorType": "CPU",
        "availability": true
    },
    {
        "id": 1,
        "name": "Apple",
        "seriesNumber": "WLX20360E1",
        "color": "white",
        "size": 30,
        "price": 150000,
        "category": "work",
        "processorType": "CPU",
        "availability": true
    },
    {
        "id": 302,
        "name": "H",
        "seriesNumber": "12FHEWFHB377FHFWHF",
        "color": "blue",
        "size": 25,
        "price": 200000,
        "category": "person",
        "processorType": "CPU",
        "availability": true
    },
    {
        "id": 252,
        "name": "Lenovo",
        "seriesNumber": "TGTRHGTR000W7447",
        "color": "red",
        "size": 38,
        "price": 90000,
        "category": "work",
        "processorType": "CPU",
        "availability": true
    },
    {
        "id": 254,
        "name": "MSI",
        "seriesNumber": "WEGWERGWJUUJUZZ",
        "color": "red",
        "size": 38,
        "price": 50000,
        "category": "work",
        "processorType": "CPU",
        "availability": true
    },
    {
        "id": 3,
        "name": "Samsung",
        "seriesNumber": "WWDFG234HDF45",
        "color": "white",
        "size": 30,
        "price": 110000,
        "category": "work",
        "processorType": "CPU",
        "availability": true
    }
]
```

- Отсортированный список Компьютеров по конкретному цвету:
```sh
localhost:8081/computer/getSortComputerName
```
- Результат запроса:
```sh
[
    {
        "id": 252,
        "name": "Lenovo",
        "seriesNumber": "TGTRHGTR000W7447",
        "color": "red",
        "size": 38,
        "price": 90000,
        "category": "work",
        "processorType": "CPU",
        "availability": true
    },
    {
        "id": 253,
        "name": "apple",
        "seriesNumber": "JRTERQQ12FEW2",
        "color": "red",
        "size": 38,
        "price": 150000,
        "category": "work",
        "processorType": "CPU",
        "availability": true
    },
    {
        "id": 254,
        "name": "MSI",
        "seriesNumber": "WEGWERGWJUUJUZZ",
        "color": "red",
        "size": 38,
        "price": 50000,
        "category": "work",
        "processorType": "CPU",
        "availability": true
    }
]
```

- Отсортированный список Компьютеров по конкретному имени:
```sh
localhost:8081/computer/getSortAllComputerLikeName
```
- Результат запроса:
```sh
[
    {
        "id": 1,
        "name": "Apple",
        "seriesNumber": "WLX20360E1",
        "color": "white",
        "size": 30,
        "price": 150000,
        "category": "work",
        "processorType": "CPU",
        "availability": true
    },
    {
        "id": 253,
        "name": "apple",
        "seriesNumber": "JRTERQQ12FEW2",
        "color": "red",
        "size": 38,
        "price": 150000,
        "category": "work",
        "processorType": "CPU",
        "availability": true
    }
]
```

**Для всех остальных моделей добавление и сортировка проиходят аналогичным образом (указывается неообходимый реквест)!**


### Модель Fridge
-- Методы запросов:
* Добавление
```sh
localhost:8081/fridge/add
```
* JSON-объектры для добавления:
```sh
{
    "name": "Beko",
    "seriesNumber": "JEHWFJW132HEF1892",
    "color": "green",
    "size": 150,
    "price": 50000,
    "doorsNumber": "1",
    "compressorType": "piston",
    "availability": true
}

{
    "name": "beko",
    "seriesNumber": "ZNBSCBBHSZ23ABHCJ133",
    "color": "green",
    "size": 150,
    "price": 55000,
    "doorsNumber": "1",
    "compressorType": "piston",
    "availability": true
}

{
    "name": "LG",
    "seriesNumber": "ZNBSCBBHSZ23ABHCJ133",
    "color": "silver",
    "size": 170,
    "price": 75000,
    "doorsNumber": "2",
    "compressorType": "piston",
    "availability": true
}
```
* Отсортированный список цен Холодильников
```sh
localhost:8081/fridge/getSortFridgePrice
```
* Отсортированный список имен Холодильников
```sh
localhost:8081/fridge/getSortFridgeName
```
* Отсортированный список Холодильников по цене
```sh
localhost:8081/fridge/getSortAllFridgeByPrice
```
* Отсортированный список Холодильников по имени в алфавитном порядке
```sh
localhost:8081/fridge/getSortAllFridgeByName
```
* Отсортированный список Холодильников по конкретному цвету
```sh
localhost:8081/fridge/getSortAllFridgeByColor
```
* Отсортированный список Холодильников по конкретному имени
```sh
localhost:8081/fridge/getSortAllFridgeLikeName
```


### Модель Smartphone
-- Методы запросов:
* Добавление
```sh
localhost:8081/smartphone/add
```
* JSON-объектры для добавления:
```sh
{
    "name": "Xiaomi",
    "seriesNumber": "LWFKWEFK12QWFQ31-0DW",
    "color": "silver",
    "size": 5,
    "price": 30000,
    "memory": "32",
    "camerasNumber": 4,
    "availability": true
}

{
    "name": "xiaomi",
    "seriesNumber": "wefwegwegwwegdqw",
    "color": "silver",
    "size": 5,
    "price": 35000,
    "memory": "32",
    "camerasNumber": 4,
    "availability": true
}

{
    "name": "Iphone",
    "seriesNumber": "KLKKJN2JKJKQJQDQ22",
    "color": "black",
    "size": 7,
    "price": 120000,
    "memory": "16",
    "camerasNumber": 8,
    "availability": false
}
```
* Отсортированный список цен Смартфонов
```sh
localhost:8081/smartphone/getSortSmartphonePrice
```
* Отсортированный список имен Смартфонов
```sh
localhost:8081/smartphone/getSortSmartphoneName
```
* Отсортированный список Смартфонов по цене
```sh
localhost:8081/smartphone/getSortAllSmartphoneByPrice
```
* Отсортированный список Смартфонов по имени в алфавитном порядке
```sh
localhost:8081/smartphone/getSortAllSmartphoneByName
```
* Отсортированный список Смартфонов по конкретному цвету
```sh
localhost:8081/smartphone/getSortAllSmartphoneByColor
```
* Отсортированный список Смартфонов по конкретному имени
```sh
localhost:8081/smartphone/getSortAllSmartphoneLikeName
```


### Модель Television
-- Методы запросов:
* Добавление
```sh
localhost:8081/television/add
```
* JSON-объектры для добавления:
```sh
{
    "name": "LG",
    "seriesNumber": "EIOWFIWE901290DWQKLQWK",
    "color": "white",
    "size": 32,
    "price": 120000,
    "category": "office",
    "technology": "3D",
    "availability": false
}

{
    "name": "Lg",
    "seriesNumber": "UYUYFE77QWDGY62",
    "color": "white",
    "size": 34,
    "price": 135000,
    "category": "office",
    "technology": "3D",
    "availability": true
}

{
    "name": "Huawei",
    "seriesNumber": "UYUYFE77QW43434555",
    "color": "white",
    "size": 34,
    "price": 90000,
    "category": "home",
    "technology": "plasma",
    "availability": true
}
```
* Отсортированный список цен Телевизоров
```sh
localhost:8081/television/getSortTelevisionPrice
```
* Отсортированный список имен Телевизоров
```sh
localhost:8081/television/getSortTelevisionName
```
* Отсортированный список Телевизоров по цене
```sh
localhost:8081/television/getSortAllTelevisionByPrice
```
* Отсортированный список Телевизоров по имени в алфавитном порядке
```sh
localhost:8081/television/getSortAllTelevisionByName
```
* Отсортированный список Телевизоров по конкретному цвету
```sh
localhost:8081/television/getSortAllTelevisionByColor
```
* Отсортированный список Телевизоров по конкретному имени
```sh
localhost:8081/television/getSortAllTelevisionLikeName
```



### Модель VacuumCleaner
-- Методы запросов:
* Добавление
```sh
localhost:8081/vacuumCleaner/add
```
* JSON-объектры для добавления:
```sh
{
    "name": "Dyson",
    "seriesNumber": "EGHFHW387JEFJ783W3",
    "color": "green",
    "size": 10,
    "price": 20000,
    "containerVolume": 2,
    "numberModes": 4,
    "availability": false
}

{
    "name": "dyson",
    "seriesNumber": "HERFH327FEH47DW",
    "color": "green",
    "size": 10,
    "price": 30000,
    "containerVolume": 2,
    "numberModes": 4,
    "availability": false
}

{
    "name": "LG",
    "seriesNumber": "347FH37FGG52FSF",
    "color": "red",
    "size": 10,
    "price": 24000,
    "containerVolume": 2,
    "numberModes": 4,
    "availability": true
}
```
* Отсортированный список цен Пылесососов
```sh
localhost:8081/vacuumCleaner/getSortVacuumCleanerPrice
```
* Отсортированный список имен Пылесососов
```sh
localhost:8081/vacuumCleaner/getSortVacuumCleanerName
```
* Отсортированный список Пылесососов по цене
```sh
localhost:8081/vacuumCleaner/getSortAllVacuumCleanerByPrice
```
* Отсортированный список Пылесососов по имени в алфавитном порядке
```sh
localhost:8081/vacuumCleaner/getSortAllVacuumCleanerByName
```
* Отсортированный список Пылесососов по конкретному цвету
```sh
localhost:8081/vacuumCleaner/getSortAllVacuumCleanerByColor
```
* Отсортированный список Пылесососов по конкретному имени
```sh
localhost:8081/vacuumCleaner/getSortAllVacuumCleanerLikeName
```