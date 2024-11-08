package com.poiski.credcardtransaction;

import org.springframework.boot.SpringApplication;
import org.testcontainers.utility.TestcontainersConfiguration;

public class TestCredcardTransactionServiceApplication {

	public static void main(String[] args) {
		SpringApplication.from(com.poiski.credcard_transaction_service.CredcardTransactionServiceApplication::main).with(TestcontainersConfiguration.class).run(args);
	}

}
