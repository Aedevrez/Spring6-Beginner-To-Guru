package aedev.guru.MVC.services;

import java.time.LocalDateTime;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.UUID;

import org.springframework.stereotype.Service;

import aedev.guru.MVC.model.Customer;

@Service
public class BasicCustomerService implements CustomerService{

    private Map<UUID, Customer> customerMap;

    public BasicCustomerService() {
        this.customerMap = new HashMap<>();

        Customer firstCustomer = Customer.builder()
                                         .id(UUID.randomUUID())
                                         .customerName("Hakan Kaylan")
                                         .version(1)
                                         .createdDate(LocalDateTime.now())
                                         .lastModifiedDate(LocalDateTime.now())
                                         .build();

        Customer secondCustomer = Customer.builder()
                                          .id(UUID.randomUUID())
                                          .customerName("Metin Çetin")
                                          .version(2)
                                          .createdDate(LocalDateTime.now())
                                          .lastModifiedDate(LocalDateTime.now())
                                          .build();

        Customer thirdCustomer = Customer.builder()
                                         .id(UUID.randomUUID())
                                         .customerName("Leyla Zehra")
                                         .version(4)
                                         .createdDate(LocalDateTime.now())
                                         .lastModifiedDate(LocalDateTime.now())
                                         .build();

        customerMap.put(firstCustomer.getId(), firstCustomer);
        customerMap.put(secondCustomer.getId(), secondCustomer); 
        customerMap.put(thirdCustomer.getId(), thirdCustomer);                                        
    }

    @Override
    public List<Customer> listCustomers() {
        return new ArrayList<>(customerMap.values());
    }

    @Override
    public Customer getCustomerById(UUID id) {
        return customerMap.get(id);
    }

    @Override
    public Customer saveNewCustomer(Customer customer) {
        Customer newCustomer = Customer.builder()
                                         .id(UUID.randomUUID())
                                         .customerName(customer.getCustomerName())
                                         .version(customer.getVersion())
                                         .createdDate(LocalDateTime.now())
                                         .lastModifiedDate(LocalDateTime.now())
                                         .build();

        customerMap.put(newCustomer.getId(), newCustomer);

        return newCustomer;
    }

    @Override
    public void updateCustomerById(UUID customerId, Customer updatedCustomer) {
        Customer previousCustomer = customerMap.get(customerId);

        previousCustomer.setCustomerName(updatedCustomer.getCustomerName());
    }

    @Override
    public void removeCustomerById(UUID customerId) {
        customerMap.remove(customerId);
    }
    
}
