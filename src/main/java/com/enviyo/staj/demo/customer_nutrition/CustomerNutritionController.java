package com.enviyo.staj.demo.customer_nutrition;

import lombok.RequiredArgsConstructor;
import org.springframework.web.bind.annotation.*;

import java.math.BigDecimal;
import java.util.Collection;
import java.util.List;
import java.util.Map;

@RestController
@RequestMapping("/customer-nutrition")
@RequiredArgsConstructor
public class CustomerNutritionController {

    private final CustomerNutritionService customerNutritionService;

    @PostMapping
    public BigDecimal saveCustomerNutrition(@RequestBody CustomerNutritionDto customerNutritionDto) {

        return customerNutritionService.saveCustomerNutrition(customerNutritionDto);
    }

    @GetMapping
    public Collection<CustomerNutrition> findAll() {

        return customerNutritionService.findCustomerNutritions();
    }

    @GetMapping("/{customerId}")
    public Collection<CustomerNutrition> findCustomerNutritionList(@PathVariable Long customerId) {

        return customerNutritionService.findCustomerNutritionList(customerId);
    }

    @GetMapping("/{customerId}/summary")
    public Map<Object, Long> findCustomerNutritionSummary(@PathVariable Long customerId) {

        return customerNutritionService.findCustomerNutritionSummary(customerId);
    }

    @GetMapping("/{customerId}/total-calorie")
    public Map<Long, Long> findCustomerNutritionTotalCalorie(@PathVariable Long customerId) {

        return customerNutritionService.findCustomerNutritionTotalCalorie(customerId);
    }

}
