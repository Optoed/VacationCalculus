# Используем официальный образ OpenJDK 11 как базовый образ
FROM openjdk:11-jdk-slim

# Устанавливаем рабочую директорию
WORKDIR /app

# Копируем JAR-файл в рабочую директорию
COPY build/libs/CalculusNeoflex-0.0.1-SNAPSHOT.jar app.jar

# Запускаем приложение
ENTRYPOINT ["java", "-jar", "app.jar"]

# Открываем порт, на котором будет работать приложение
EXPOSE 8080
