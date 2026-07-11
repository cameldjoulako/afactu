package com.aroolia.afactu;

import com.aroolia.afactu.controller.InvoiceControllerInterface;
import org.springframework.context.ApplicationContext;
import org.springframework.context.annotation.AnnotationConfigApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;

import java.util.Scanner;


public class App
{
    public static void main( String[] args )
    {

        //ApplicationContext context = new ClassPathXmlApplicationContext("applicationContext.xml");

        ApplicationContext context = new AnnotationConfigApplicationContext(AppConfig.class);

        InvoiceControllerInterface invoiceController  = context.getBean(InvoiceControllerInterface.class);

        invoiceController.createInvoice();

    }
}