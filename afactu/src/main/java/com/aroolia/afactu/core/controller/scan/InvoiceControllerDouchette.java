package com.aroolia.afactu.core.controller.scan;

import com.aroolia.afactu.core.controller.InvoiceControllerInterface;
import com.aroolia.afactu.core.entity.Invoice;
import com.aroolia.afactu.core.service.InvoiceServiceInterface;

//@Controller
public class InvoiceControllerDouchette implements InvoiceControllerInterface {

    private InvoiceServiceInterface invoiceService;

    public InvoiceServiceInterface getInvoiceService() {
        return invoiceService;
    }

    public void setInvoiceService(InvoiceServiceInterface invoiceService) {
        this.invoiceService = invoiceService;
    }

    @Override
    public String createInvoice(Invoice invoice) {
        System.out.println("Usage of a scanner");

        invoice=new Invoice();
        invoice.setCustomerName("Virgin Galactic");

        invoiceService.createInvoice(invoice);

        return null;
    }
}