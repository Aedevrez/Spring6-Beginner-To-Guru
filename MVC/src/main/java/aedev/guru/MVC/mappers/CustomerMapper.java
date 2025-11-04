package aedev.guru.MVC.mappers;

import aedev.guru.MVC.entities.Customer;
import aedev.guru.MVC.model.CustomerDTO;
import org.mapstruct.Mapper;

@Mapper
public interface CustomerMapper {

    Customer customerDtoToCustomer(CustomerDTO dto);

    CustomerDTO customerToCustomerDto(Customer customer);
}
