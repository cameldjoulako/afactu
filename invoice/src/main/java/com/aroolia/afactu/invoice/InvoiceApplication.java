package com.aroolia.afactu.invoice;

import com.fasterxml.jackson.datatype.hibernate7.Hibernate7Module;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.persistence.autoconfigure.EntityScan;
import org.springframework.context.annotation.Bean;
import org.springframework.web.client.RestTemplate;

@SpringBootApplication
@EntityScan("com.aroolia.afactu.core.entity.invoice")
public class InvoiceApplication {

	public static void main(String[] args) {
		SpringApplication.run(InvoiceApplication.class, args);
	}

    @Bean
    public Hibernate7Module hibernate7Module() {
        Hibernate7Module module = new Hibernate7Module();
        module.disable(Hibernate7Module.Feature.USE_TRANSIENT_ANNOTATION);
        module.enable(Hibernate7Module.Feature.SERIALIZE_IDENTIFIER_FOR_LAZY_NOT_LOADED_OBJECTS);

        return module;
    }

    @Bean
    public RestTemplate getRestTemplate() {
        return new RestTemplate();
    }


}
