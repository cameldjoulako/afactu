package com.aroolia.afactu.controller;

import com.aroolia.afactu.service.InvoiceServiceInterface;
import org.springframework.stereotype.Controller;

@Controller
public interface InvoiceControllerInterface {

    void createInvoice();
    void setInvoiceService(InvoiceServiceInterface invoiceService);
}