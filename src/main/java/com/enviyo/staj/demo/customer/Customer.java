package com.enviyo.staj.demo.customer;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import java.time.LocalDate;


@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
public class Customer {

    private Long customerNo;

    private String name;

    private String surname;

    private LocalDate birthDate;

}
