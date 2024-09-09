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

## 2. Настройка Docker

Добавьте файл `Dockerfile` в корневую директорию проекта. Вот пример конфигурации для вашего Spring Boot приложения:

```dockerfile
# Используем официальный образ OpenJDK как базовый образ
FROM openjdk:17-jdk-slim

# Устанавливаем рабочую директорию
WORKDIR /app

# Копируем JAR-файл в рабочую директорию
COPY build/libs/CalculusNeoflex-0.0.1-SNAPSHOT.jar app.jar

# Запускаем приложение
ENTRYPOINT ["java", "-jar", "app.jar"]

# Открываем порт, на котором будет работать приложение
EXPOSE 8080
```

Добавьте также файл docker-compose.yml для упрощения запуска Docker-контейнера:
```dockerfile
version: '3.8'

services:
  app:
    build:
      context: .
      dockerfile: Dockerfile
    ports:
      - "8080:8080"
    environment:
      - SPRING_PROFILES_ACTIVE=prod
```

### Команды для работы с Docker

1. Сборка Docker-образа:
```bash
docker build -t vacation-calculator .
```

2. Запуск контейнера:
```bash
docker run -p 8080:8080 vacation-calculator
```

3. Запуск с использованием Docker Compose:
```bash
docker-compose up
```

### Остановка docker-контейнера

1. Сначала найдите ID контейнера, который вы хотите завершить.
```bash
docker ps
```

2. После того как вы получите ID контейнера, завершите его с помощью команды docker stop:
```bash
docker stop <container_id>
```

## Лиценция

Этот проект лицензирован под лицензией MIT.