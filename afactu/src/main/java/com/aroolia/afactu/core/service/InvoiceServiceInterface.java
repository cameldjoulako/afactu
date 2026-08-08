package com.aroolia.afactu.core.service;


import com.aroolia.afactu.core.entity.Invoice;
import com.aroolia.afactu.core.repository.InvoiceRepositoryInterface;
import org.springframework.stereotype.Service;

@Service
public interface InvoiceServiceInterface {
    Invoice createInvoice(Invoice invoice);

    Iterable<Invoice> getInvoiceList();

    void setInvoiceRepository(InvoiceRepositoryInterface invoiceRepository);

    Invoice getInvoiceByNumber(String number);
}