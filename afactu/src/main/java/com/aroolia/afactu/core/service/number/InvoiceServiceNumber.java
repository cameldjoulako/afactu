package com.aroolia.afactu.core.service.number;


import com.aroolia.afactu.core.entity.Invoice;

import com.aroolia.afactu.core.repository.InvoiceRepositoryInterface;
import com.aroolia.afactu.core.service.InvoiceServiceInterface;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class InvoiceServiceNumber implements InvoiceServiceInterface {

    private InvoiceRepositoryInterface invoiceRepository;

    public InvoiceRepositoryInterface getInvoiceRepository() {
        return invoiceRepository;
    }

    @Override
    public Iterable<Invoice> getInvoiceList() {

/*
        Iterable<Invoice> invoices =  invoiceRepository.findAll();


        //initialisation du client de chaque facture
        invoices.forEach(invoice -> {
            invoice.getCustomer().getName();
        });

        return invoices;
        */


        return invoiceRepository.findAll();
    }

    @Autowired
    public void setInvoiceRepository(InvoiceRepositoryInterface invoiceRepository) {
        this.invoiceRepository = invoiceRepository;
    }

    public Invoice createInvoice(Invoice invoice){
        //invoice.setNumber(String.valueOf(++lastNumber));//la bd se charge


        return invoiceRepository.save(invoice);

        //return invoice;
    }



    @Override
    public Invoice getInvoiceByNumber(String number) {
        return invoiceRepository.findById(number).orElseThrow();
    }
}