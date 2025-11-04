package aedev.guru.MVC.services;

import aedev.guru.MVC.mappers.CustomerMapper;
import aedev.guru.MVC.model.CustomerDTO;
import aedev.guru.MVC.repositories.CustomerRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.context.annotation.Primary;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;
import java.util.UUID;

@Service
@Primary
@RequiredArgsConstructor
public class CustomerServiceJPA implements CustomerService {
    private final CustomerRepository customerRepository;
    private final CustomerMapper customerMapper;

    @Override
    public List<CustomerDTO> listCustomers() {
        return customerRepository.findAll()
                .stream()
                .map(customerMapper::customerToCustomerDto)
                .toList();
    }

    @Override
    public Optional<CustomerDTO> getCustomerById(UUID id) {
        return Optional.ofNullable((customerMapper.customerToCustomerDto(customerRepository.findById(id).orElse(null))));
    }

    @Override
    public CustomerDTO saveNewCustomer(CustomerDTO CustomerDTO) {
        return null;
    }

    @Override
    public void updateCustomerById(UUID customerId, CustomerDTO updatedCustomer) {

    }

    @Override
    public void removeCustomerById(UUID customerId) {

    }

    @Override
    public void patchCustomerById(UUID customerId, CustomerDTO patchedCustomer) {

    }
}
