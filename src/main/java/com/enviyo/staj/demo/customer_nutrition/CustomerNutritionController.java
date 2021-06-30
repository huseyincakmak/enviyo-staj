package com.enviyo.staj.demo.customer_nutrition;

import lombok.RequiredArgsConstructor;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.math.BigDecimal;

@RestController
@RequestMapping("/customer-nutrition")
@RequiredArgsConstructor
public class CustomerNutritionController {

    private final CustomerNutritionService customerNutritionService;

    @PostMapping
    public BigDecimal saveCustomerNutrition(@RequestBody CustomerNutritionDto customerNutritionDto) {

        return customerNutritionService.saveCustomerNutrition(customerNutritionDto);
    }

}
