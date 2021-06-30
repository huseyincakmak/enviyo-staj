package com.enviyo.staj.demo.customer_nutrition;

import com.enviyo.staj.demo.customer.Customer;
import com.enviyo.staj.demo.customer.CustomerService;
import com.enviyo.staj.demo.exception.BadRequestException;
import com.enviyo.staj.demo.food.Food;
import com.enviyo.staj.demo.food.FoodService;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Service;

import java.math.BigDecimal;
import java.time.LocalDateTime;
import java.util.Optional;

@Service
@Slf4j
@RequiredArgsConstructor
public class CustomerNutritionService {

    private final CustomerNutritionRepository customerNutritionRepository;

    private final CustomerService customerService;

    private final FoodService foodService;

    public BigDecimal saveCustomerNutrition(CustomerNutritionDto customerNutritionDto) {

        final Long customerId = customerNutritionDto.getCustomerId();
        Optional<Customer> customerOptional = customerService.findCustomer(customerId);
        if(customerOptional.isEmpty()) {

            throw new BadRequestException("Müşteri bulunamadı");
        }

        final Long foodId = customerNutritionDto.getFoodId();
        Optional<Food> foodOptional = foodService.findFood(foodId);
        if(foodOptional.isEmpty()) {

            throw new BadRequestException("Yiyecek türü bulunamadı");
        }

        CustomerNutrition customerNutrition = CustomerNutritionMapper.CUSTOMER_NUTRITION_MAPPER.convertToCustomerNutrition(customerNutritionDto);
        customerNutrition.setInsertDate(LocalDateTime.now());
        customerNutritionRepository.save(customerNutrition);

        final Food food = foodOptional.get();
        final BigDecimal defaultAmount = food.getAmount();
        final BigDecimal defaultCalorie = food.getCalorie();
        final BigDecimal customerNutritionAmount =  customerNutrition.getAmount();

        return customerNutritionAmount.divide(defaultAmount).multiply(defaultCalorie);
    }

}
