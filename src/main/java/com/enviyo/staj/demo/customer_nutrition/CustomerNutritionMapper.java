package com.enviyo.staj.demo.customer_nutrition;

import com.enviyo.staj.demo.customer.Customer;
import org.mapstruct.Mapper;
import org.mapstruct.factory.Mappers;

@Mapper
public interface CustomerNutritionMapper {

    CustomerNutritionMapper CUSTOMER_NUTRITION_MAPPER = Mappers.getMapper(CustomerNutritionMapper.class);

    CustomerNutrition convertToCustomerNutrition(CustomerNutritionDto customerNutritionDto);

}

