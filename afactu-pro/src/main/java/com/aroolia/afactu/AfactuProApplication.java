package com.aroolia.afactu;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.data.jdbc.repository.config.EnableJdbcRepositories;

@SpringBootApplication
//@EnableJdbcRepositories
public class AfactuProApplication {

	public static void main(String[] args) {

        SpringApplication.run(AfactuProApplication.class, args);
	}

}
