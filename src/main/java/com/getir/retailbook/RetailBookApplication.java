package com.getir.retailbook;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.data.mongodb.repository.config.EnableMongoRepositories;

@SpringBootApplication
@EnableMongoRepositories
public class RetailBookApplication {

	public static void main(String[] args) {
		SpringApplication.run(RetailBookApplication.class, args);
	}

}
