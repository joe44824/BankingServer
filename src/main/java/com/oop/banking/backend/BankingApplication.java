package com.oop.banking.backend;

import com.oop.banking.backend.entity.Customer;
import com.oop.banking.backend.repository.CustomerRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

@SpringBootApplication
public class BankingApplication implements CommandLineRunner {

	@Autowired
	private CustomerRepository customerRepository;

	public static void main(String[] args) {
		SpringApplication.run(BankingApplication.class, args);
	}


	@Override
	public void run(String... args) throws Exception {
		Customer[] customers = new Customer[] {
				new Customer(1, "John", "Lee", 222222),
				new Customer(2, "Steve", "Ann", 222222),
				new Customer(3, "Siri", "East", 222222),
				new Customer(4, "Neville", "Tay", 222222),
				new Customer(5, "Ron", "Weasley", 222222),
		};

		for (int i = 0; i < customers.length; i ++) {
			customerRepository.save(customers[i]);
		}


	}
}
