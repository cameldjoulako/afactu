package com.aroolia.afactu.controller;

import com.aroolia.afactu.entity.Invoice;

import com.aroolia.afactu.service.InvoiceServiceInterface;
import org.springframework.beans.factory.annotation.Autowired;


public class InvoiceControllerWeb implements InvoiceControllerInterface {

    @Autowired
    private InvoiceServiceInterface invoiceService;

    public InvoiceServiceInterface getInvoiceService() {
        return invoiceService;
    }

    public void setInvoiceService(InvoiceServiceInterface invoiceService) {
        this.invoiceService = invoiceService;
    }

    public void createInvoice(){

        String customerName="Tesla";
        Invoice invoice=new Invoice();
        invoice.setCustomerName(customerName);

        invoiceService.createInvoice(invoice);
    }
}