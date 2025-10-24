package aedev.guru.MVC.controllers;

import java.util.List;
import java.util.UUID;

import org.springframework.http.HttpHeaders;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import aedev.guru.MVC.model.CustomerDTO;
import aedev.guru.MVC.services.CustomerService;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;

@Slf4j
@RequiredArgsConstructor
@RestController
public class CustomerController {
    public static final String CUSTOMER_PATH = "/api/v1/customer";
    public static final String CUSTOMER_PATH_ID = CUSTOMER_PATH + "/{customerId}";

    private final CustomerService customerService;

    @GetMapping(CUSTOMER_PATH)
    public List<CustomerDTO> listCustomers() {
        return customerService.listCustomers();
    }

    @GetMapping(CUSTOMER_PATH_ID)
    public CustomerDTO getCustomerById(@PathVariable UUID customerId) {
        return customerService.getCustomerById(customerId).orElseThrow(NotFoundException::new);
    }

    @PostMapping(CUSTOMER_PATH)
    public ResponseEntity saveCustomer(@RequestBody CustomerDTO CustomerDTO) {
        CustomerDTO saved = customerService.saveNewCustomer(CustomerDTO);

        log.debug(saved.getCustomerName());

        HttpHeaders headers = new HttpHeaders();
        headers.add("Location", "/api/v1/customer/" + saved.getId().toString());

        return new ResponseEntity<>(headers, HttpStatus.CREATED);
    }

    @PutMapping(CUSTOMER_PATH_ID)
    public ResponseEntity updateCustomerById(@PathVariable UUID customerId, @RequestBody CustomerDTO updatedCustomer) {
        customerService.updateCustomerById(customerId, updatedCustomer);

        return new ResponseEntity<>(HttpStatus.NO_CONTENT);
    }

    @DeleteMapping(CUSTOMER_PATH_ID)
    public ResponseEntity deleteCustomerById(@PathVariable UUID customerId) {
        customerService.removeCustomerById(customerId);

        return new ResponseEntity<>(HttpStatus.NO_CONTENT);
    }

    @PatchMapping(CUSTOMER_PATH_ID)
    public ResponseEntity patchCustomerById(@PathVariable UUID customerId, @RequestBody CustomerDTO updatedCustomer) {
        customerService.patchCustomerById(customerId, updatedCustomer);

        return new ResponseEntity<>(HttpStatus.NO_CONTENT);
    }
}
