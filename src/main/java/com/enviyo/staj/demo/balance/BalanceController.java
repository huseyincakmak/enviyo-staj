package com.enviyo.staj.demo.balance;


import com.enviyo.staj.demo.customer.CustomerService;
import com.enviyo.staj.demo.exception.BadRequestException;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
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
    public ResponseEntity<BalanceResponseDto> withdrawMoney(@RequestBody BalanceOperationRequestDto balanceOperationRequestDto) {

        return  new ResponseEntity<BalanceResponseDto>(customerService.withdrawMoney(balanceOperationRequestDto), HttpStatus.OK);
    }

}
