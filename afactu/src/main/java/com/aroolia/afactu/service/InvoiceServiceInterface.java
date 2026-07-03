package com.aroolia.afactu.service;


import com.aroolia.afactu.entity.Invoice;
import com.aroolia.afactu.repository.InvoiceRepositoryInterface;
import org.springframework.stereotype.Service;

@Service
public interface InvoiceServiceInterface {
    void createInvoice(Invoice invoice);
    void setInvoiceRepository(InvoiceRepositoryInterface invoiceRepository);
}