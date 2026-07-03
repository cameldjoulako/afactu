package com.aroolia.afactu.service;

import com.aroolia.afactu.entity.Invoice;
import com.aroolia.afactu.repository.InvoiceRepositoryInterface;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;

import java.io.File;


public class InvoiceServicePrefix implements InvoiceServiceInterface{

    @Value("${invoice.lastNumber}")
    private long lastNumber;

    @Value("${invoice.prefix}")
    private String prefix;

    public long getLastNumber() {
        return lastNumber;
    }

    public void setLastNumber(long lastNumber) {
        this.lastNumber = lastNumber;
    }

    public String getPrefix() {
        return prefix;
    }

    public void setPrefix(String prefix) {
        this.prefix = prefix;
    }


    @Autowired
    private InvoiceRepositoryInterface invoiceRepository;

    public InvoiceRepositoryInterface getInvoiceRepository() {
        return invoiceRepository;
    }

    public void setInvoiceRepository(InvoiceRepositoryInterface invoiceRepository) {
        this.invoiceRepository = invoiceRepository;
    }

    public void createInvoice(Invoice invoice){
        invoice.setNumber( prefix + (++lastNumber));
        invoiceRepository.create(invoice);
    }
}