package com.oop.banking.backend.service;

import com.oop.banking.backend.entity.Customer;
import org.springframework.stereotype.Service;

import java.util.List;

public interface CustomerService {
    Customer createCustomer(int bankId, Customer customer);

    Customer getCustomer(int id);

    Customer updateCustomer(int id, Customer customer);

    String deleteCustomer(int id);

    List<Customer> getCustomers();

}
