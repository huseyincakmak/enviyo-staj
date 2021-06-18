package com.enviyo.staj.demo.balance;


import com.enviyo.staj.demo.customer.CustomerService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/balance")
public class BalanceController {

    @Autowired
    private CustomerService customerService;

    @PostMapping("/add")
    public BalanceResponseDto addMoney(@RequestBody BalanceOperationRequestDto balanceOperationRequestDto) {

        return customerService.addMoney(balanceOperationRequestDto);
    }

    @PostMapping("/remove")
    public BalanceResponseDto withdrawMoney(@RequestBody BalanceOperationRequestDto balanceOperationRequestDto) throws Exception {

        return customerService.withdrawMoney(balanceOperationRequestDto);
    }

}
