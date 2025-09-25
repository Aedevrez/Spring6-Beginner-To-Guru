package aedev.guru.MVC.services;

import java.util.List;
import java.util.UUID;

import aedev.guru.MVC.model.Customer;

public interface CustomerService {
    List<Customer> listCustomers();
    Customer getCustomerById(UUID id);
    Customer saveNewCustomer(Customer customer);
    void updateCustomerById(UUID customerId, Customer updatedCustomer);
    void removeCustomerById(UUID customerId);
}
