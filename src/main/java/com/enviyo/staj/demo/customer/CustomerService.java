package com.enviyo.staj.demo.customer;

import com.enviyo.staj.demo.balance.BalanceOperationRequestDto;
import com.enviyo.staj.demo.balance.BalanceResponseDto;
import com.enviyo.staj.demo.exception.BadRequestException;
import com.enviyo.staj.demo.exception.NotAcceptableException;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.math.BigDecimal;
import java.util.List;
import java.util.Optional;

@Slf4j
@Service
public class CustomerService {

    @Autowired
    private CustomerRepository customerRepository;

    public List<Customer> getAllCustomers() {

        return customerRepository.findAll();
    }

    public void addCustomer(CustomerDto customerDto) {

        final Customer customerYeni = CustomerMapper.CUSTOMER_MAPPER.convertToCustomer(customerDto);
        customerYeni.setBalance(BigDecimal.ZERO);

        customerRepository.save(customerYeni);
    }

    public void deleteCustomer(Long customerNo) {

        customerRepository.deleteById(customerNo);
    }

    public BalanceResponseDto addMoney(BalanceOperationRequestDto balanceOperationRequestDto) {

        final Long customerNo = balanceOperationRequestDto.getCustomerNo();

        final BigDecimal amount = balanceOperationRequestDto.getAmount();

        if(amount.compareTo(BigDecimal.ZERO) <= 0 ){

            log.error("Geçersiz tutar iletildi Tutar : {}, Customer: {}", amount, customerNo);
            throw new NotAcceptableException("Geçersiz tutar");
        }

        final Optional<Customer> customerOptional = findCustomer(customerNo);

        if (customerOptional.isPresent()) {

            final Customer customer = customerOptional.get();

            customer.setBalance(customer.getBalance().add(balanceOperationRequestDto.getAmount()));

            customerRepository.save(customer);

            return getBalanceResponseDto(customer);
        }

        return new BalanceResponseDto();
    }


    public BalanceResponseDto withdrawMoney(BalanceOperationRequestDto balanceOperationRequestDto) {

        final Long customerNo = balanceOperationRequestDto.getCustomerNo();

        final Optional<Customer> customerOptional = findCustomer(customerNo);

        if (customerOptional.isPresent()) {

            final Customer customer = customerOptional.get();

            final BigDecimal amount = balanceOperationRequestDto.getAmount();

            if(customer.getBalance().compareTo(amount) == -1){

                log.error("Yetersiz bakiye Tutar : {}, Customer: {}", amount, customerNo);

                 throw new BadRequestException("Yeterli bakiyeniz bulunmamaktadır");
            }

            customer.setBalance(customer.getBalance().subtract(balanceOperationRequestDto.getAmount()));

            customerRepository.save(customer);

            return getBalanceResponseDto(customer);
        }

        return new BalanceResponseDto();
    }

    public Optional<Customer> findCustomer(Long customerNo) {

        final Optional<Customer> customerOptional = customerRepository.findById(customerNo);

        return customerOptional;
    }

    private BalanceResponseDto getBalanceResponseDto(Customer customer) {

        final BalanceResponseDto balanceResponseDto = new BalanceResponseDto();

        balanceResponseDto.setCustomerNo(customer.getCustomerNo());

        balanceResponseDto.setBalance(customer.getBalance());

        return balanceResponseDto;
    }

}
