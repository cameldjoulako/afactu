package com.aroolia.afactu;

import org.springframework.context.annotation.ComponentScan;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.PropertySource;

@Configuration
@ComponentScan(basePackages = {"com.aroolia.afactu.controller.web", "com.aroolia.afactu.service.prefix", "com.aroolia.afactu.repository.database"})
@PropertySource("classpath:application.properties")
public class AppConfig {


}
