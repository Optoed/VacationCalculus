package com.example.calculusneoflex;

import com.example.calculusneoflex.model.VacationRequest;
import com.example.calculusneoflex.model.VacationResponse;
import com.example.calculusneoflex.service.VacationService;
import org.junit.jupiter.api.Test;
import org.springframework.boot.test.context.SpringBootTest;

import java.time.LocalDate;

import static org.junit.jupiter.api.Assertions.assertEquals;

@SpringBootTest
class CalculusNeoflexApplicationTests {

    private final VacationService vacationService = new VacationService();

    @Test
    public void testCalculateVacationPaymentByDays() {
        VacationRequest request = new VacationRequest(60000, 14);
        VacationResponse response = vacationService.calculateVacationPayment(request);
        double expectedPayment = 60000 / 29.3 * 14; // Ожидаемое значение
        assertEquals(expectedPayment, response.getVacationPayment(), 0.01);
    }

    @Test
    public void testCalculateVacationPaymentByDates() {
        VacationRequest request = new VacationRequest(60000, 0);
        LocalDate startDate = LocalDate.of(2024, 8, 1);
        LocalDate endDate = LocalDate.of(2024, 8, 14);
        VacationResponse response = vacationService.calculateVacationPayment(request, startDate, endDate);
        double dailySalary = 60000 / 30; // Используем 30 для упрощения
        int workingDays = 10; // Примерное количество рабочих дней в этом диапазоне
        double expectedPayment = dailySalary * workingDays;
        assertEquals(expectedPayment, response.getVacationPayment(), 0.01);
    }

    @Test
    public void testCalculateVacationPaymentWithHolidays() {
        VacationRequest request = new VacationRequest(60000, 0);
        LocalDate startDate = LocalDate.of(2024, 1, 1); // Праздничный день
        LocalDate endDate = LocalDate.of(2024, 1, 2);  // Не праздничный день
        VacationResponse response = vacationService.calculateVacationPayment(request, startDate, endDate);
        double dailySalary = 60000 / 30;
        int workingDays = 1; // один день - праздничный
        double expectedPayment = dailySalary * workingDays;
        assertEquals(expectedPayment, response.getVacationPayment(), 0.01);
    }

}
