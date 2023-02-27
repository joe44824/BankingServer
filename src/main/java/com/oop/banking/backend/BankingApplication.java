package com.oop.banking.backend;

import com.oop.banking.backend.entity.Bank;
import com.oop.banking.backend.entity.Customer;
import com.oop.banking.backend.repository.BankRepository;
import com.oop.banking.backend.repository.CustomerRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.Bean;
import org.springframework.jdbc.core.JdbcTemplate;

@SpringBootApplication
public class BankingApplication implements CommandLineRunner {

	@Autowired
	private CustomerRepository customerRepository;

	@Autowired
	private BankRepository bankRepository;

	@Autowired
	private JdbcTemplate jdbcTemplate;


	public static void main(String[] args) {
		SpringApplication.run(BankingApplication.class, args);
	}


	@Override
	public void run(String... args) throws Exception {

		Bank[] banks = new Bank[]{
				new Bank(1, "HENG", false),
				new Bank(2, "DBS", true),
				new Bank(3, "OCBC", true),
				new Bank(4, "EXPRESS", false)
		};

		for (int i = 0; i < banks.length; i++) {
			bankRepository.save(banks[i]);
		}

		jdbcTemplate.update("INSERT INTO customer (id, first_name, last_name, hashed_pin, bank_id, username) VALUES (1, 'JAMES', 'CHARLES', 111111, 1, 'jamie111')");


	}


}
