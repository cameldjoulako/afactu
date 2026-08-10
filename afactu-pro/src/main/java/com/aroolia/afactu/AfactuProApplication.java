package com.aroolia.afactu;

import com.fasterxml.jackson.datatype.hibernate7.Hibernate7Module;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.Bean;


@SpringBootApplication
public class AfactuProApplication {

	public static void main(String[] args) {

        SpringApplication.run(AfactuProApplication.class, args);
	}

    @Bean
    public Hibernate7Module hibernate7Module() {
        return new Hibernate7Module();
    }


}
