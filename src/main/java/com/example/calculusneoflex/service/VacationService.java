package com.example.calculusneoflex.service;

import com.example.calculusneoflex.model.VacationRequest;
import com.example.calculusneoflex.model.VacationResponse;
import org.springframework.stereotype.Service;

import java.io.InputStream;
import java.time.DayOfWeek;
import java.time.LocalDate;
import java.util.Calendar;
import java.util.HashSet;
import java.util.Set;

@Service
public class VacationService {

    private final Set<LocalDate> holidays;

    public VacationService() {
        holidays = new HashSet<>();
        addHolidaysForYear(2023);
        addHolidaysForYear(2024);
        addHolidaysForYear(2025);
    }

    public VacationResponse calculateVacationPayment(VacationRequest request) {
        double dailySalary = request.getAverageSalary() / 29.3; // 29.3 - стандарт
        double vacationPayment = dailySalary * request.getVacationDays();
        return new VacationResponse(vacationPayment);
    }

    public VacationResponse calculateVacationPayment(VacationRequest request, LocalDate startDate, LocalDate endDate) {
        double dailySalary = request.getAverageSalary() / 30; // Используем 30 для упрощения
        int workingDays = calculateWorkingDays(startDate, endDate);
        double vacationPayment = dailySalary * workingDays;
        return new VacationResponse(vacationPayment);
    }

    private int calculateWorkingDays(LocalDate startDate, LocalDate endDate) {
        int workingDays = 0;
        LocalDate currentDate = startDate;

        while (!currentDate.isAfter(endDate)) {
            if (!isHolidayOrWeekend(currentDate)) {
                workingDays++;
            }
            currentDate = currentDate.plusDays(1);
        }

        return workingDays;
    }

    private boolean isHolidayOrWeekend(LocalDate date) {
        DayOfWeek dayOfWeek = date.getDayOfWeek();
        return (dayOfWeek == DayOfWeek.SATURDAY) || (dayOfWeek == DayOfWeek.SUNDAY) || holidays.contains(date);
    }

    private void addHolidaysForYear(int year) {
        holidays.add(LocalDate.of(year, 1, 1));  // Новый Год
        holidays.add(LocalDate.of(year, 1, 7));  // Рождество (по старому стилю)
        holidays.add(LocalDate.of(year, 2, 23)); // День Защитника Отечества
        holidays.add(LocalDate.of(year, 3, 8));  // Международный Женский День
        holidays.add(LocalDate.of(year, 5, 1));  // Праздник Весны и Труда
        holidays.add(LocalDate.of(year, 5, 9));  // День Победы
        holidays.add(LocalDate.of(year, 6, 12)); // День России
        holidays.add(LocalDate.of(year, 11, 4)); // День Народного Единства
        holidays.add(LocalDate.of(year, 12, 31)); // Новый Год (предпраздничный день)
    }
}