package com.example.calculusneoflex.service;

import com.example.calculusneoflex.model.VacationRequest;
import com.example.calculusneoflex.model.VacationResponse;
import org.springframework.stereotype.Service;

@Service
public class VacationService {

    public VacationResponse calculateVacationPayment(VacationRequest request) {

        double dailySalary = request.getAverageSalary() / 29.3; // Расчет дневного заработка

        double vacationPayment = dailySalary * request.getVacationDays();

        return new VacationResponse(vacationPayment);
    }
}