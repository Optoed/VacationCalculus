package com.example.calculusneoflex;

import com.example.calculusneoflex.model.VacationRequest;
import com.example.calculusneoflex.model.VacationResponse;
import com.example.calculusneoflex.service.VacationService;
import org.junit.jupiter.api.Test;
import org.springframework.boot.test.context.SpringBootTest;

import static org.junit.jupiter.api.Assertions.assertEquals;

@SpringBootTest
class CalculusNeoflexApplicationTests {

    @Test
    public void testCalculateVacationPayment() {

        VacationService vacationService = new VacationService();

        VacationRequest request = new VacationRequest(60000, 14);

        VacationResponse response = vacationService.calculateVacationPayment(request);

        assertEquals(28633.79, response.getVacationPayment(), 0.01);
    }

}
