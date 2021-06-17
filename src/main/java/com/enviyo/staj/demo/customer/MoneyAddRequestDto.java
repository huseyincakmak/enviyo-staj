package com.enviyo.staj.demo.customer;


import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import java.math.BigDecimal;

@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
public class MoneyAddRequestDto {

    private Long customerNo;

    private BigDecimal amount;

}
