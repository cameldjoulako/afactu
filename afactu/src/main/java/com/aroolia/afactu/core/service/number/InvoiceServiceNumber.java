package com.aroolia.afactu.core.service.number;


import com.aroolia.afactu.core.entity.Invoice;

import com.aroolia.afactu.core.repository.InvoiceRepositoryInterface;
import com.aroolia.afactu.core.service.InvoiceServiceInterface;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class InvoiceServiceNumber implements InvoiceServiceInterface {

    //private static long lastNumber=0L;
    //@Autowired
    private InvoiceRepositoryInterface invoiceRepository;

    public InvoiceRepositoryInterface getInvoiceRepository() {
        return invoiceRepository;
    }

    public void setInvoiceRepository(InvoiceRepositoryInterface invoiceRepository) {
        this.invoiceRepository = invoiceRepository;
    }

    public Invoice createInvoice(Invoice invoice){
        //invoice.setNumber(String.valueOf(++lastNumber));//la bd se charge


        return invoiceRepository.create(invoice);

        //return invoice;
    }

    @Override
    public List<Invoice> getInvoiceList() {
        return invoiceRepository.list();
    }

    @Override
    public Invoice getInvoiceByNumber(String number) {
        return invoiceRepository.getById(number);
    }
}