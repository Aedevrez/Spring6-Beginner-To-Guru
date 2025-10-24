package aedev.guru.MVC.services;

import java.time.LocalDateTime;
import java.util.*;

import org.springframework.stereotype.Service;

import aedev.guru.MVC.model.CustomerDTO;

@Service
public class BasicCustomerService implements CustomerService{

    private Map<UUID, CustomerDTO> customerMap;

    public BasicCustomerService() {
        this.customerMap = new HashMap<>();

        CustomerDTO firstCustomer = CustomerDTO.builder()
                                         .id(UUID.randomUUID())
                                         .customerName("Hakan Kaylan")
                                         .version(1)
                                         .createdDate(LocalDateTime.now())
                                         .lastModifiedDate(LocalDateTime.now())
                                         .build();

        CustomerDTO secondCustomer = CustomerDTO.builder()
                                          .id(UUID.randomUUID())
                                          .customerName("Metin Çetin")
                                          .version(2)
                                          .createdDate(LocalDateTime.now())
                                          .lastModifiedDate(LocalDateTime.now())
                                          .build();

        CustomerDTO thirdCustomer = CustomerDTO.builder()
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
    public List<CustomerDTO> listCustomers() {
        return new ArrayList<>(customerMap.values());
    }

    @Override
    public Optional<CustomerDTO> getCustomerById(UUID id) {
        return Optional.of(customerMap.get(id));
    }

    @Override
    public CustomerDTO saveNewCustomer(CustomerDTO CustomerDTO) {
        CustomerDTO newCustomer = CustomerDTO.builder()
                                         .id(UUID.randomUUID())
                                         .customerName(CustomerDTO.getCustomerName())
                                         .version(CustomerDTO.getVersion())
                                         .createdDate(LocalDateTime.now())
                                         .lastModifiedDate(LocalDateTime.now())
                                         .build();

        customerMap.put(newCustomer.getId(), newCustomer);

        return newCustomer;
    }

    @Override
    public void updateCustomerById(UUID customerId, CustomerDTO updatedCustomer) {
        CustomerDTO previousCustomer = customerMap.get(customerId);

        previousCustomer.setCustomerName(updatedCustomer.getCustomerName());
    }

    @Override
    public void removeCustomerById(UUID customerId) {
        customerMap.remove(customerId);
    }

    @Override
    public void patchCustomerById(UUID customerId, CustomerDTO patchedCustomer) {
        CustomerDTO existingCustomer = customerMap.get(customerId);

        if (patchedCustomer.getCustomerName() != null) {
            existingCustomer.setCustomerName(patchedCustomer.getCustomerName());
        }

        if (patchedCustomer.getVersion() != null) {
            existingCustomer.setVersion(patchedCustomer.getVersion());
        }
    }
    
}
