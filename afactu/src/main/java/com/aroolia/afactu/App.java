package com.aroolia.afactu;

import com.aroolia.afactu.controller.InvoiceControllerInterface;
import org.springframework.context.ApplicationContext;
import org.springframework.context.annotation.AnnotationConfigApplicationContext;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.PropertySource;
import org.springframework.context.support.ClassPathXmlApplicationContext;

import java.util.Scanner;

@Configuration
@ComponentScan(basePackages = {"com.aroolia.afactu.controller.web", "com.aroolia.afactu.service.prefix", "com.aroolia.afactu.repository.database"})
@PropertySource("classpath:application.properties")
public class App
{
    public static void main( String[] args )
    {

        //ApplicationContext context = new ClassPathXmlApplicationContext("applicationContext.xml");

        ApplicationContext context = new AnnotationConfigApplicationContext(App.class);

        InvoiceControllerInterface invoiceController  = context.getBean(InvoiceControllerInterface.class);

        invoiceController.createInvoice();

    }
}