package com.enviyo.staj.demo.balance;


import com.enviyo.staj.demo.customer.CustomerService;
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
    public ResponseEntity<?> withdrawMoney(@RequestBody BalanceOperationRequestDto balanceOperationRequestDto) throws Exception {

        try{
            return  new ResponseEntity<BalanceResponseDto>(customerService.withdrawMoney(balanceOperationRequestDto), HttpStatus.OK);
        } catch (Exception e) {
            String s =  e.getMessage();
            return  new ResponseEntity<>(s , HttpStatus.BAD_REQUEST);
        }

    }

}
