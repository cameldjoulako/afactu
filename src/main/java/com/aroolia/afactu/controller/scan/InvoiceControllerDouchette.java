package com.aroolia.afactu.controller.scan;

import com.aroolia.afactu.controller.InvoiceControllerInterface;
import com.aroolia.afactu.entity.Invoice;
import com.aroolia.afactu.service.InvoiceServiceInterface;
import org.springframework.stereotype.Controller;

@Controller
public class InvoiceControllerDouchette implements InvoiceControllerInterface {

    private InvoiceServiceInterface invoiceService;

    public InvoiceServiceInterface getInvoiceService() {
        return invoiceService;
    }

    public void setInvoiceService(InvoiceServiceInterface invoiceService) {
        this.invoiceService = invoiceService;
    }

    @Override
    public void createInvoice() {
        System.out.println("Usage of a scanner");
        Invoice invoice=new Invoice();
        invoice.setCustomerName("Virgin Galactic");
        invoiceService.createInvoice(invoice);
    }
}