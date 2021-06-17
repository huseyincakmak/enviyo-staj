package com.enviyo.staj.demo.customer;

import org.springframework.stereotype.Service;

import java.math.BigDecimal;
import java.time.LocalDate;
import java.util.ArrayList;
import java.util.List;
import java.util.Optional;
import java.util.Random;

@Service
public class CustomerService {

    private static List<Customer> CUSTOMER_LIST = new ArrayList<>();

    static {
        CUSTOMER_LIST.add(new Customer(Long.parseLong("1"), "Ahmet", "Dursun", LocalDate.of(1976, 11, 6), BigDecimal.ZERO));
    }

    public List<Customer> getAllCustomers() {

        return CUSTOMER_LIST;
    }

    public void addCustomer(CustomerDto customerDto) {

        Customer customerYeni = CustomerMapper.CUSTOMER_MAPPER.convertToCustomer(customerDto);
        customerYeni.setCustomerNo(new Random().nextLong());
        customerYeni.setBalance(BigDecimal.ZERO);

        CUSTOMER_LIST.add(customerYeni);
    }

    public void deleteCustomer(Long customerNo) {

        //customerNo değeri listedeki customerlardan herhangi birinin customerNosuna eşit ise siler.
        //Predicate
        CUSTOMER_LIST.removeIf(customer -> customerNo.equals(customer.getCustomerNo()));
    }

    public BalanceResponseDto addMoney(MoneyAddRequestDto moneyAddRequestDto) {

        Long customerNo = moneyAddRequestDto.getCustomerNo();

        Optional<Customer> customerOptional = CUSTOMER_LIST.stream().filter(cssda -> cssda.getCustomerNo().equals(customerNo)).findFirst();

        if(customerOptional.isPresent()) {
            Customer customer = customerOptional.get();

            customer.setBalance(customer.getBalance().add(moneyAddRequestDto.getAmount()));

            BalanceResponseDto balanceResponseDto = new BalanceResponseDto();
            balanceResponseDto.setCustomerNo(customer.getCustomerNo());
            balanceResponseDto.setBalance(customer.getBalance());

            return balanceResponseDto;
        }

        return new BalanceResponseDto();
    }


}
