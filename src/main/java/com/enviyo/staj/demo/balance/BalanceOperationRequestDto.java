package com.enviyo.staj.demo.balance;


import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import java.math.BigDecimal;

@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
public class BalanceOperationRequestDto {

    private Long customerNo;

    private BigDecimal amount;

}
