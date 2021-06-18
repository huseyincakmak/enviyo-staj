package com.enviyo.staj.demo.customer;

import com.enviyo.staj.demo.balance.BalanceResponseDto;
import com.enviyo.staj.demo.balance.BalanceOperationRequestDto;
import org.springframework.stereotype.Service;

import java.math.BigDecimal;
import java.time.LocalDate;
import java.util.ArrayList;
import java.util.List;
import java.util.Optional;
import java.util.Random;

@Service
public class CustomerService {

    private final static List<Customer> CUSTOMER_LIST = new ArrayList<>();

    static {
        CUSTOMER_LIST.add(new Customer(Long.parseLong("1"), "Ahmet", "Dursun", LocalDate.of(1976, 11, 6), BigDecimal.ZERO));
    }

    public List<Customer> getAllCustomers() {

        return CUSTOMER_LIST;
    }

    public void addCustomer(CustomerDto customerDto) {

        final Customer customerYeni = CustomerMapper.CUSTOMER_MAPPER.convertToCustomer(customerDto);
        customerYeni.setCustomerNo(new Random().nextLong());
        customerYeni.setBalance(BigDecimal.ZERO);

        CUSTOMER_LIST.add(customerYeni);
    }

    public void deleteCustomer(Long customerNo) {

        //customerNo değeri listedeki customerlardan herhangi birinin customerNosuna eşit ise siler.
        //Predicate
        CUSTOMER_LIST.removeIf(customer -> customerNo.equals(customer.getCustomerNo()));
    }

    public BalanceResponseDto addMoney(BalanceOperationRequestDto balanceOperationRequestDto) {

        final Long customerNo = balanceOperationRequestDto.getCustomerNo();

        final Optional<Customer> customerOptional = findCustomer(customerNo);

        if (customerOptional.isPresent()) {

            final Customer customer = customerOptional.get();

            customer.setBalance(customer.getBalance().add(balanceOperationRequestDto.getAmount()));

            return getBalanceResponseDto(customer);
        }

        return new BalanceResponseDto();
    }


    public BalanceResponseDto withdrawMoney(BalanceOperationRequestDto balanceOperationRequestDto) throws Exception {

        final Long customerNo = balanceOperationRequestDto.getCustomerNo();

        final Optional<Customer> customerOptional = findCustomer(customerNo);

        if (customerOptional.isPresent()) {

            final Customer customer = customerOptional.get();

            if(customer.getBalance().compareTo(balanceOperationRequestDto.getAmount()) == -1){

                 throw new Exception("Yeterli bakiyeniz bulunmamaktadır");
            }

            customer.setBalance(customer.getBalance().subtract(balanceOperationRequestDto.getAmount()));

            return getBalanceResponseDto(customer);
        }

        return new BalanceResponseDto();
    }

    private Optional<Customer> findCustomer(Long customerNo) {

        final Optional<Customer> customerOptional = CUSTOMER_LIST.stream().filter(cssda -> cssda.getCustomerNo().equals(customerNo)).findFirst();

        return customerOptional;
    }

    private BalanceResponseDto getBalanceResponseDto(Customer customer) {

        final BalanceResponseDto balanceResponseDto = new BalanceResponseDto();
        balanceResponseDto.setCustomerNo(customer.getCustomerNo());
        balanceResponseDto.setBalance(customer.getBalance());

        return balanceResponseDto;
    }


}
