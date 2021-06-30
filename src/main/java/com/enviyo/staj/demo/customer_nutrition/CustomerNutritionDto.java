package com.enviyo.staj.demo.customer_nutrition;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import java.math.BigDecimal;

@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
public class CustomerNutritionDto {

    private Long customerId;

    private Long foodId;

    private BigDecimal amount;

}
