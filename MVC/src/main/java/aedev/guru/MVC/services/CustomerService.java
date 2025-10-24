package aedev.guru.MVC.services;

import java.util.List;
import java.util.Optional;
import java.util.UUID;

import aedev.guru.MVC.model.CustomerDTO;

public interface CustomerService {
    List<CustomerDTO> listCustomers();
    Optional<CustomerDTO> getCustomerById(UUID id);
    CustomerDTO saveNewCustomer(CustomerDTO CustomerDTO);
    void updateCustomerById(UUID customerId, CustomerDTO updatedCustomer);
    void removeCustomerById(UUID customerId);
    void patchCustomerById(UUID customerId, CustomerDTO patchedCustomer);
}
