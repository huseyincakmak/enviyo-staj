package com.enviyo.staj.demo.customer_nutrition;

import lombok.Getter;
import lombok.Setter;

import javax.persistence.*;
import java.math.BigDecimal;
import java.time.LocalDateTime;


@Getter
@Setter
@Entity
@Table(name = "customer_nutrition")
public class CustomerNutrition {

    @Id
    @GeneratedValue(strategy= GenerationType.IDENTITY)
    private Long id;

    private Long customerId;

    private Long foodId;

    private BigDecimal amount;

    private LocalDateTime insertDate;

}
