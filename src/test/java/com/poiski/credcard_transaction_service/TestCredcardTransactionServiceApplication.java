package com.poiski.credcard_transaction_service;

import org.springframework.boot.SpringApplication;

public class TestCredcardTransactionServiceApplication {

	public static void main(String[] args) {
		SpringApplication.from(CredcardTransactionServiceApplication::main).with(TestcontainersConfiguration.class).run(args);
	}

}
