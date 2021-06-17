package com.enviyo.staj.demo.customer;


import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/balance")
public class BalanceController {

    @Autowired
    private CustomerService customerService;

    @PostMapping("/add")
    public BalanceResponseDto addMoney(@RequestBody MoneyAddRequestDto moneyAddRequestDto) {

        return customerService.addMoney(moneyAddRequestDto);
    }

}
