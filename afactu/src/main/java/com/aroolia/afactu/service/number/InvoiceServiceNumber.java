package com.aroolia.afactu.service.number;


import com.aroolia.afactu.entity.Invoice;

import com.aroolia.afactu.repository.InvoiceRepositoryInterface;
import com.aroolia.afactu.service.InvoiceServiceInterface;
import org.springframework.stereotype.Service;

//@Service
public class InvoiceServiceNumber implements InvoiceServiceInterface {

    private static long lastNumber=0L;

    private InvoiceRepositoryInterface invoiceRepository;

    public InvoiceRepositoryInterface getInvoiceRepository() {
        return invoiceRepository;
    }

    public void setInvoiceRepository(InvoiceRepositoryInterface invoiceRepository) {
        this.invoiceRepository = invoiceRepository;
    }

    public void createInvoice(Invoice invoice){
        invoice.setNumber(String.valueOf(++lastNumber));
        invoiceRepository.create(invoice);
    }
}