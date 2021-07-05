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
import java.security.KeyStore;
import java.time.LocalDateTime;
import java.util.*;
import java.util.stream.Collectors;

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

    public Collection<CustomerNutrition> findCustomerNutritions() {

        return customerNutritionRepository.findAll();
    }

    public Collection<CustomerNutrition> findCustomerNutritionList(Long customerId) {

        return customerNutritionRepository.findByCustomerId(customerId);
    }

    public Map<Object, Long> findCustomerNutritionSummary(Long customerId) {

        Collection<CustomerNutrition> customerNutritions = customerNutritionRepository.findByCustomerId(customerId);

        Map<Object, Long> objectLongMap  = customerNutritions.stream().collect(Collectors.groupingBy(t -> t.getFoodId(), Collectors.counting() ));

        return objectLongMap;
    }

    public Map<Long, Long> findCustomerNutritionTotalCalorie(Long customerId) {

        Collection<CustomerNutrition> customerNutritions = customerNutritionRepository.findByCustomerId(customerId);

        Collection<Food> foodCollection = foodService.findAll();

        Map<Long, Long> objectLongMap  = customerNutritions.stream().collect(Collectors.groupingBy(t -> t.getFoodId(), Collectors.counting() ));

        Set<Map.Entry<Long, Long>> entrySet = objectLongMap.entrySet();

        ArrayList<Map.Entry<Long, Long>> listOfEntry = new ArrayList<Map.Entry<Long, Long>>(entrySet);

        Map<Long, Long> totalCalories = new HashMap<>();

        /* Aşağıdaki forEach ile aynı işi yapan for döngüsü:
        *
            for(Map.Entry<Long, Long> entry : listOfEntry) {

                Food food = foodCollection.stream().filter(t -> t.getId().equals(entry.getKey())).findFirst().get();

                totalCalories.put(entry.getKey(), entry.getValue().longValue() * food.getCalorie().longValue());
            }
        *
        */

        listOfEntry.forEach(q -> {

            Food food = foodCollection.stream().filter(t -> t.getId().equals(q.getKey())).findFirst().get();

            totalCalories.put(q.getKey(), q.getValue().longValue() * food.getCalorie().longValue());

        });

        return totalCalories;
    }
}
