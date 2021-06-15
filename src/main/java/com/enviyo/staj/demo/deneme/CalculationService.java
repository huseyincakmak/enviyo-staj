package com.enviyo.staj.demo.deneme;

import org.springframework.stereotype.Service;

import java.math.BigDecimal;

@Service
public class CalculationService {

    public BigDecimal add(BigDecimal number1, BigDecimal number2) {

        return number1.add(number2);
    }

    public BigDecimal subtract(BigDecimal number1, BigDecimal number2) {

        return number1.subtract(number2);
    }

    public BigDecimal multiply(BigDecimal number1, BigDecimal number2) {

        return number1.multiply(number2);
    }

    public BigDecimal divide(BigDecimal number1, BigDecimal number2) {

        return number1.divide(number2);
    }

}
