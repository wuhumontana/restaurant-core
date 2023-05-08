package com.ex.base.controllers;

import com.ex.base.entity.customer;
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
        customer customerr = customerRepository.findById(id).orElse(null);
        if (customerr == null) {
            return ResponseEntity.notFound().build();
        } else {
            return ResponseEntity.ok(customerr);
        }
    }

    @PostMapping("/customers")
    public customer createCustomer(@RequestBody customer customerRequest) {
        String username = customerRequest.getUsername();
        String password = customerRequest.getPassword();
        String email = customerRequest.getEmail();
        String phone = customerRequest.getPhone();

        customer customers = new customer(username, password, email, phone);
        return customerRepository.save(customers);
    }

    @PutMapping(value = "/updatecustomer/{id}")
    public ResponseEntity updateCustomer(@PathVariable(value = "id") Long id, @RequestBody customer updatedCustomer) {
        customer customers = customerRepository.findById(id).orElse(null);
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

    @DeleteMapping(value = "/deletecustomer")
    public ResponseEntity removeCustomer(@RequestParam(value ="id") Long id) {
        customer customers = customerRepository.findById(id).orElse(null);
        if (customers == null) {
            return ResponseEntity.notFound().build();
        } else {
            customerRepository.delete(customers);
            return ResponseEntity.ok().build();
        }
    }

}