package com.enviyo.staj.demo.customer;

import org.springframework.stereotype.Service;

import java.time.LocalDate;
import java.util.ArrayList;
import java.util.List;

@Service
public class CustomerService {

    private static List<Customer> CUSTOMER_LIST = new ArrayList<>();

    static {
        CUSTOMER_LIST.add(new Customer(Long.parseLong("1"), "Ahmet", "Dursun", LocalDate.of(1976, 11, 6)));
        CUSTOMER_LIST.add(new Customer(Long.parseLong("2"), "Mehmet", "Demir", LocalDate.of(1977, 1, 6)));
        CUSTOMER_LIST.add(new Customer(Long.parseLong("3"), "Emre", "Öztürk", LocalDate.of(1978, 2, 6)));
        CUSTOMER_LIST.add(new Customer(Long.parseLong("4"), "Ali", "Ayhan", LocalDate.of(1979, 3, 6)));
        CUSTOMER_LIST.add(new Customer(Long.parseLong("5"), "Hamit", "Erdemir", LocalDate.of(1971, 10, 4)));
        CUSTOMER_LIST.add(new Customer(Long.parseLong("6"), "Mahmut", "Aldemir", LocalDate.of(1972, 10, 7)));
        CUSTOMER_LIST.add(new Customer(Long.parseLong("7"), "Kerem", "Coskun", LocalDate.of(1972, 10, 9)));
        CUSTOMER_LIST.add(new Customer(Long.parseLong("8"), "Canan", "Ozsay", LocalDate.of(1974, 10, 6)));
    }

    public List<Customer> getAllCustomers() {

        return CUSTOMER_LIST;
    }

    public void addCustomer(Customer customer) {

        CUSTOMER_LIST.add(customer);
    }

    public void deleteCustomer(Long customerNo) {

        //customerNo değeri listedeki customerlardan herhangi birinin customerNosuna eşit ise siler.
        //Predicate
        CUSTOMER_LIST.removeIf(customer -> customerNo.equals(customer.getCustomerNo()));
    }

}
