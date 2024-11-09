package com.poiski.credcardtransaction.outbound.repository.config;

import org.springframework.boot.autoconfigure.EnableAutoConfiguration;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.context.annotation.Configuration;
import org.springframework.data.jpa.repository.config.EnableJpaRepositories;

@Configuration
@EnableAutoConfiguration
@EnableJpaRepositories("com.poiski.credcardtransaction")
@ComponentScan("com.poiski.credcardtransaction")
public class JpaConfig {
}
