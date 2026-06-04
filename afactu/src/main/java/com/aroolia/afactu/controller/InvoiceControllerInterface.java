package com.aroolia.afactu.controller;

import com.aroolia.afactu.service.InvoiceServiceInterface;

public interface InvoiceControllerInterface {

    void createInvoice();
    void setInvoiceService(InvoiceServiceInterface invoiceService);
}