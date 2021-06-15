package com.enviyo.staj.demo.deneme;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.math.BigDecimal;

@RestController
@RequestMapping("/calculate")
public class CalculatorController{

    @Autowired
    private CalculationService calculationService;

    @PostMapping("/add")
    public BigDecimal add(@RequestBody CalculationPart calculationPart) {

        return this.calculationService.add(calculationPart.getNumber1(), calculationPart.getNumber2());
    }

    @PostMapping("/subtract")
    public BigDecimal subtract(@RequestBody CalculationPart calculationPart) {

        return this.calculationService.subtract(calculationPart.getNumber1(), calculationPart.getNumber2());
    }

    @PostMapping("/multiply")
    public BigDecimal multiply(@RequestBody CalculationPart calculationPart) {

        return this.calculationService.multiply(calculationPart.getNumber1(), calculationPart.getNumber2());
    }

    @PostMapping("/divide")
    public BigDecimal divide(@RequestBody CalculationPart calculationPart) {

        return this.calculationService.divide(calculationPart.getNumber1(), calculationPart.getNumber2());

    }

}
