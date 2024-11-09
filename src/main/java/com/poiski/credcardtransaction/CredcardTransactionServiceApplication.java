package com.poiski.credcardtransaction;

import lombok.extern.slf4j.Slf4j;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.autoconfigure.security.servlet.SecurityAutoConfiguration;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.Statement;

@Slf4j
@SpringBootApplication(exclude = {SecurityAutoConfiguration.class})
public class CredcardTransactionServiceApplication {

	public static void main(String[] args) {
    Connection connection = null;
    Statement statement = null;
    try {
      log.info("Creating database if not exist...");
      connection = DriverManager.getConnection("jdbc:postgresql://localhost:5432/", "postgres", "postgres");
      statement = connection.createStatement();
      statement.executeQuery("SELECT count(*) FROM pg_database WHERE datname = 'credcarddb'");
      ResultSet resultSet = statement.getResultSet();
      resultSet.next();
      int count = resultSet.getInt(1);

      if (count <= 0) {
        statement.executeUpdate("CREATE DATABASE credcarddb");
        log.info("Database created.");
      } else {
        log.info("Database already exist.");
      }
    } catch (Exception e) {
      log.error(e.toString());
    } finally {
      try {
        if (statement != null) {
          statement.close();
          log.info("Closed Statement.");
        }
        if (connection != null) {
          log.info("Closed Connection.");
          connection.close();
        }
      } catch (Exception e) {
        log.error(e.toString());
      }
    }

    SpringApplication.run(CredcardTransactionServiceApplication.class, args);
	}

}
