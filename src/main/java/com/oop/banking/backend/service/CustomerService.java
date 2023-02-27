package com.oop.banking.backend.service;

import com.oop.banking.backend.entity.Customer;
import org.springframework.stereotype.Service;

import java.util.List;

public interface CustomerService {
    Customer createCustomer(int bankId, Customer customer);

    Customer getCustomer(String id);

    Customer updateCustomer(String id, Customer customer);

    String deleteCustomer(String id);

    List<Customer> getCustomers();

}
