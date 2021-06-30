package com.enviyo.staj.demo.food;

import com.enviyo.staj.demo.models.MeasurementType;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import javax.persistence.*;
import java.math.BigDecimal;

@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
@Entity
@Table(name = "food")
public class Food {

    @Id
    @GeneratedValue(strategy= GenerationType.IDENTITY)
    private Long id;

    private String name;

    private BigDecimal calorie;

    private MeasurementType measurementType;

    private BigDecimal amount;

}
