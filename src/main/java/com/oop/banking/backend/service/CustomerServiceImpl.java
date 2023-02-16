package com.oop.banking.backend.service;

import com.oop.banking.backend.entity.Customer;
import com.oop.banking.backend.repository.CustomerRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class CustomerServiceImpl implements CustomerService{

    @Autowired
    private CustomerRepository customerRepository;

    public Customer createCustomer(Customer customer) {
        return customerRepository.save(customer);
    }

    public Customer getCustomer(int id) {
        return customerRepository.findById(id).get();
    }

    public Customer updateCustomer(int id, Customer customer) {
        Customer existingCustomer = customerRepository.findById(id).orElse(null);

            existingCustomer.setFirstName(customer.getFirstName());
            existingCustomer.setLastName(customer.getLastName());
            existingCustomer.setHashedPin(customer.getHashedPin());

        return customerRepository.save(existingCustomer);
    }


    public String deleteCustomer(int id) {
        customerRepository.deleteById(id);
        return "Customer (" + id + ") removed";
    }

    public List<Customer> getCustomers() {
        return (List<Customer>) customerRepository.findAll();

    }


}
