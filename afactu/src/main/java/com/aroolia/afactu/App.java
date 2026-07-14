package com.aroolia.afactu;

import com.aroolia.afactu.controller.InvoiceControllerInterface;
import com.aroolia.afactu.service.InvoiceServiceInterface;
import com.aroolia.afactu.service.prefix.InvoiceServicePrefix;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.ApplicationContext;
import org.springframework.context.annotation.*;
import org.springframework.context.support.ClassPathXmlApplicationContext;

import java.util.Scanner;
@SpringBootApplication
/*@Configuration
@ComponentScan
*/
@PropertySource("classpath:application.properties")
public class App
{
    public static void main( String[] args )
    {

        //ApplicationContext context = new ClassPathXmlApplicationContext("applicationContext.xml" );

        ApplicationContext context = new AnnotationConfigApplicationContext(App.class);

        InvoiceControllerInterface invoiceController  = context.getBean(InvoiceControllerInterface.class);

        invoiceController.createInvoice();

    }
}