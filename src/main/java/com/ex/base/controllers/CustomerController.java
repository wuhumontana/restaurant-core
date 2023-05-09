package com.ex.base.controllers;

import com.ex.base.entity.Customer;
import com.ex.base.jpa.myCustomerRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@RestController
public class CustomerController {

    @Autowired
    private myCustomerRepository customerRepository;

    @GetMapping(value = "/customer")
    public ResponseEntity getCustomer(@RequestParam(value ="id") Long id) {
        Customer customerr = customerRepository.findById(id).orElse(null);
        if (customerr == null) {
            return ResponseEntity.notFound().build();
        } else {
            return ResponseEntity.ok(customerr);
        }
    }

    @PostMapping("/customer")
    public Customer createCustomer(@RequestBody Customer customerRequest) {
        String username = customerRequest.getUsername();
        String password = customerRequest.getPassword();
        String email = customerRequest.getEmail();
        String phone = customerRequest.getPhone();

        Customer customers = new Customer(username, password, email, phone);
        return customerRepository.save(customers);
    }

    @PutMapping(value = "/customer/{id}")
    public ResponseEntity updateCustomer(@PathVariable(value = "id") Long id, @RequestBody Customer updatedCustomer) {
        Customer customers = customerRepository.findById(id).orElse(null);
        if (customers == null) {
            return ResponseEntity.notFound().build();
        } else {
            customers.setUsername(updatedCustomer.getUsername());
            customers.setPassword(updatedCustomer.getPassword());
            customers.setEmail(updatedCustomer.getEmail());
            customers.setPhone(updatedCustomer.getPhone());
            customerRepository.save(customers);
            return ResponseEntity.ok(customers);
        }
    }

    @DeleteMapping(value = "/customer")
    public ResponseEntity removeCustomer(@RequestParam(value ="id") Long id) {
        Customer customers = customerRepository.findById(id).orElse(null);
        if (customers == null) {
            return ResponseEntity.notFound().build();
        } else {
            customerRepository.delete(customers);
            return ResponseEntity.ok().build();
        }
    }

}