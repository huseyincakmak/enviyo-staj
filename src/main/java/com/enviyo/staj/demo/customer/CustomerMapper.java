package com.enviyo.staj.demo.customer;

import org.mapstruct.Mapper;
import org.mapstruct.factory.Mappers;

@Mapper
public interface CustomerMapper {

    CustomerMapper CUSTOMER_MAPPER = Mappers.getMapper(CustomerMapper.class);

    Customer  convertToCustomer(CustomerDto customerDto);

}
