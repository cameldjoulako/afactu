package com.aroolia.afactu.invoice.service;


import com.aroolia.afactu.core.entity.invoice.Invoice;
import com.aroolia.afactu.invoice.repository.InvoiceRepositoryInterface;
import org.springframework.stereotype.Service;

@Service
public interface InvoiceServiceInterface {
    Invoice createInvoice(Invoice invoice);

    Iterable<Invoice> getInvoiceList();

    void setInvoiceRepository(InvoiceRepositoryInterface invoiceRepository);

    Invoice getInvoiceByNumber(String number);
}