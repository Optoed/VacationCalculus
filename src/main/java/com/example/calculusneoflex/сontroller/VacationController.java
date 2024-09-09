package com.example.calculusneoflex.сontroller;

import com.example.calculusneoflex.model.VacationRequest;
import com.example.calculusneoflex.model.VacationResponse;
import com.example.calculusneoflex.service.VacationService;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

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
}