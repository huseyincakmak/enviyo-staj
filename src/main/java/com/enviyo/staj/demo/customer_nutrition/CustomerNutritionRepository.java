package com.enviyo.staj.demo.customer_nutrition;

import org.springframework.data.jpa.repository.JpaRepository;

import java.time.LocalDateTime;
import java.util.Collection;

public interface CustomerNutritionRepository extends JpaRepository<CustomerNutrition, Long> {

    Collection<CustomerNutrition> findByCustomerId(Long customerId);

    Collection<CustomerNutrition> findByCustomerIdAndInsertDate(Long customerId, LocalDateTime insertDate);

}
