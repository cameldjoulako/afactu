package com.aroolia.afactu.invoice.controller;

import com.aroolia.afactu.core.entity.invoice.Invoice;
import com.aroolia.afactu.invoice.service.InvoiceServiceInterface;
import org.springframework.stereotype.Controller;

@Controller
public interface InvoiceControllerInterface {

    String createInvoice(Invoice invoice);
    void setInvoiceService(InvoiceServiceInterface invoiceService);
}