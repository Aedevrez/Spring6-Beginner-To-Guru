package aedev.guru.MVC.controllers;

import java.util.List;
import java.util.UUID;

import org.springframework.http.HttpHeaders;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

import aedev.guru.MVC.model.Customer;
import aedev.guru.MVC.services.CustomerService;
import lombok.AllArgsConstructor;
import lombok.extern.slf4j.Slf4j;

@Slf4j
@AllArgsConstructor
@RestController
@RequestMapping("/api/v1/customer")
public class CustomerController {

    private CustomerService customerService;

    @RequestMapping(method = RequestMethod.GET)
    public List<Customer> listCustomers() {
        return customerService.listCustomers();
    }

    @RequestMapping(value = "{customerId}", method = RequestMethod.GET)
    public Customer getCustomerById(@PathVariable UUID customerId) {
        return customerService.getCustomerById(customerId);
    }

    @PostMapping
    public ResponseEntity saveCustomer(@RequestBody Customer customer) {
        Customer saved = customerService.saveNewCustomer(customer);

        log.debug(saved.getCustomerName());

        HttpHeaders headers = new HttpHeaders();
        headers.add("Location", "/api/v1/customer/" + saved.getId().toString());

        return new ResponseEntity<>(headers, HttpStatus.CREATED);
    }

    @PutMapping("{customerId}")
    public ResponseEntity updateCustomerById(@PathVariable UUID customerId, @RequestBody Customer updatedCustomer) {
        customerService.updateCustomerById(customerId, updatedCustomer);

        return new ResponseEntity<>(HttpStatus.NO_CONTENT);
    }

    @DeleteMapping("{customerId}")
    public ResponseEntity deleteCustomerById(@PathVariable UUID customerId) {
        customerService.removeCustomerById(customerId);

        return new ResponseEntity<>(HttpStatus.NO_CONTENT);
    }
}
