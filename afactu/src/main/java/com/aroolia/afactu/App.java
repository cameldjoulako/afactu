package com.aroolia.afactu;

import com.aroolia.afactu.controller.InvoiceControllerInterface;
import com.aroolia.afactu.controller.InvoiceControllerKeyboard;
import com.aroolia.afactu.controller.InvoiceControllerDouchette;
import com.aroolia.afactu.controller.InvoiceControllerWeb;
import com.aroolia.afactu.repository.InvoiceRepositoryInterface;
import com.aroolia.afactu.repository.InvoiceRepositoryMemory;
import com.aroolia.afactu.repository.InvoiceRepositoryDatabase;
import com.aroolia.afactu.service.InvoiceServiceInterface;
import com.aroolia.afactu.service.InvoiceServiceNumber;
import com.aroolia.afactu.service.InvoiceServicePrefix;

import java.util.Scanner;


public class App
{
    public static void main( String[] args )
    {

        Scanner sc=new Scanner(System.in);
        System.out.println("Quel est la classe de controller  ?");
        String controllerClass=sc.nextLine();
        System.out.println("Quel est la classe de service ?");
        String serviceClass=sc.nextLine();
        System.out.println("Quel est la classe repository ?");
        String repositoryClass=sc.nextLine();


        InvoiceControllerInterface invoiceController=null;

        InvoiceServiceInterface invoiceService=null;

        InvoiceRepositoryInterface invoiceRepository=null;

        try {
            invoiceController = (InvoiceControllerInterface) Class.forName(controllerClass).getDeclaredConstructor().newInstance();
            invoiceService = (InvoiceServiceInterface) Class.forName(serviceClass).getDeclaredConstructor().newInstance();
            invoiceRepository = (InvoiceRepositoryInterface) Class.forName(repositoryClass).getDeclaredConstructor().newInstance();
        }
        catch (Exception e){
            e.printStackTrace();
        }


        invoiceController.setInvoiceService(invoiceService);
        invoiceService.setInvoiceRepository(invoiceRepository);

        invoiceController.createInvoice();
    }
}