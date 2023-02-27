package com.oop.banking.backend.controller;

import com.oop.banking.backend.entity.Customer;
import com.oop.banking.backend.service.CustomerService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
public class CustomerController {

    @Autowired
    private CustomerService service;

    @PostMapping("/customer/{bankId}")
    public ResponseEntity<Customer> createCustomer(@PathVariable int bankId, @RequestBody Customer customer) {
        return new ResponseEntity<>(service.createCustomer(bankId, customer), HttpStatus.CREATED);
    }

    @GetMapping("/customer/{id}")
    public ResponseEntity<Customer> getCustomer(@PathVariable String id) {
        return new ResponseEntity<>(service.getCustomer(id), HttpStatus.OK);
    }


    @PutMapping("/customer/{id}")
    public ResponseEntity<Customer> updateCustomer(@PathVariable String id, @RequestBody Customer customer) {
        return new ResponseEntity<>(service.updateCustomer(id, customer), HttpStatus.OK);
    }

    @DeleteMapping("/customer/{id}")
    public ResponseEntity<String> deleteCustomer(@PathVariable String id) {
        return new ResponseEntity<>(service.deleteCustomer(id), HttpStatus.OK);
    }

    @GetMapping("/customer/all")
    public ResponseEntity<List<Customer>> getCustomers() {
        return new ResponseEntity<>(service.getCustomers(), HttpStatus.OK);
    }

}
