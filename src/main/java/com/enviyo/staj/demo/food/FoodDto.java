package com.enviyo.staj.demo.food;

import com.enviyo.staj.demo.models.MeasurementType;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import java.math.BigDecimal;

@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
public class FoodDto {

    private String name;

    private BigDecimal calorie;

    private MeasurementType measurementType;

    private BigDecimal amount;
}
