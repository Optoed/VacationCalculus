package com.example.calculusneoflex.сontroller;

import com.example.calculusneoflex.model.VacationRequest;
import com.example.calculusneoflex.model.VacationResponse;
import com.example.calculusneoflex.service.VacationService;
import org.springframework.web.bind.annotation.*;

import java.time.LocalDate;

@RestController
@RequestMapping("/calculate")
public class VacationController {

    private final VacationService vacationService;

    public VacationController(VacationService vacationService) {
        this.vacationService = vacationService;
    }

    @GetMapping
    public VacationResponse calculateVacation(@RequestParam double averageSalary,
                                              @RequestParam int vacationDays) {
        VacationRequest request = new VacationRequest(averageSalary, vacationDays);
        return vacationService.calculateVacationPayment(request);
    }

    @PostMapping
    public VacationResponse calculateVacation(@RequestParam double averageSalary,
                                              @RequestParam String startDate,
                                              @RequestParam String endDate) {
        VacationRequest request = new VacationRequest(averageSalary, 0);

        LocalDate start = LocalDate.parse(startDate);
        LocalDate end = LocalDate.parse(endDate);

        return vacationService.calculateVacationPayment(request, start, end);
    }
}