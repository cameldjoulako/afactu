package com.aroolia.afactu.core.controller;

import com.aroolia.afactu.core.service.InvoiceServiceInterface;
import org.springframework.stereotype.Controller;

@Controller
public interface InvoiceControllerInterface {

    void createInvoice();
    void setInvoiceService(InvoiceServiceInterface invoiceService);
}