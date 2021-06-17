package com.enviyo.staj.demo.customer;


import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/customer")
public class CustomerController {

    @Autowired
    private CustomerService customerService;

    @GetMapping
    public List<Customer> getAllCustomers() {

        return customerService.getAllCustomers();
    }

    @PostMapping
    public void addCustomer(@RequestBody CustomerDto customerDto) {

        customerService.addCustomer(customerDto);
    }

    @DeleteMapping("/{customerNo}")
    public void deleteCustomer(@PathVariable Long customerNo) {

        customerService.deleteCustomer(customerNo);
    }

}
