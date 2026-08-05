package com.aroolia.afactu.core.repository.memory;

import com.aroolia.afactu.core.entity.Invoice;
import com.aroolia.afactu.core.repository.InvoiceRepositoryInterface;

import java.util.ArrayList;
import java.util.List;

//@Repository
public class InvoiceRepositoryMemory implements InvoiceRepositoryInterface {

    private static List<Invoice> invoices=new ArrayList<>();

    public Invoice create(Invoice invoice){
        invoices.add(invoice);
        System.out.println("Invoice added with number "+invoice.getNumber()+" for "+invoice.getCustomerName());
        //return null;

        throw new UnsupportedOperationException("Not supported yet.");
    }

    @Override
    public List<Invoice> list() {
        throw new UnsupportedOperationException("Not supported yet.");
    }

    @Override
    public Invoice getById(String number) {

        throw new UnsupportedOperationException("Not supported yet.");
    }
}