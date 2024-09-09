# Vacation Calculator

## Описание

Этот проект представляет собой калькулятор отпускных выплат. Он позволяет рассчитать отпускные выплаты на основе средней зарплаты и количества отпускных дней. В проекте реализованы два основных метода расчета:

1. **По количеству дней отпуска**: Расчет на основе среднего заработка и количества дней отпуска.
2. **По датам начала и окончания**: Расчет на основе среднего заработка и календарных дат начала и окончания отпуска, исключая выходные и праздничные дни.

## Как запустить проект

### Требования

- Java 11 (или выше)
- Gradle (или Maven)

### Сборка и запуск

1. Склонируйте репозиторий:
    ```bash
    git clone https://github.com/Optoed/VacationCalculus.git
    ```

2. Перейдите в директорию проекта:
    ```bash
    cd vacation-calculator
    ```

3. Сборка проекта с помощью Gradle:
    ```bash
    ./gradlew build
    ```

4. Запуск приложения:
    ```bash
    ./gradlew bootRun
    ```

## Примеры запросов

### GET запрос

GET /calculate?averageSalary=60000&vacationDays=14

### POST запрос

POST /calculate Content-Type: application/x-www-form-urlencoded

averageSalary=60000&startDate=2024-01-01&endDate=2024-01-07

## Тестирование

Для запуска тестов используйте команду:
```bash
./gradlew test
```





## Лиценция

Этот проект лицензирован под лицензией MIT.