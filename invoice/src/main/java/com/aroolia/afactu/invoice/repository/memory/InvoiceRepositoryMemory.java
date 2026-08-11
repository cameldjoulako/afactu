package com.aroolia.afactu.invoice.repository.memory;

import com.aroolia.afactu.core.entity.invoice.Invoice;
import com.aroolia.afactu.invoice.repository.InvoiceRepositoryInterface;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

//@Repository

public class InvoiceRepositoryMemory implements InvoiceRepositoryInterface {

    private static List<Invoice> invoices=new ArrayList<>();

    public Invoice save(Invoice invoice){
        invoices.add(invoice);
        System.out.println("Invoice added with number "+invoice.getNumber()+" for "+invoice.getCustomer().getName());
       return invoice;

        //throw new UnsupportedOperationException("Not supported yet.");
    }

    @Override
    public Iterable<Invoice> findAll() {
        throw new UnsupportedOperationException("Not supported yet.");
    }

    @Override
    public Iterable<Invoice> findAllById(Iterable<String> strings) {
        return null;
    }

    @Override
    public long count() {
        throw new UnsupportedOperationException("Not supported yet.");
    }

    @Override
    public void deleteById(String s) {
        throw new UnsupportedOperationException("Not supported yet.");
    }

    @Override
    public void delete(Invoice entity) {
        throw new UnsupportedOperationException("Not supported yet.");
    }

    @Override
    public void deleteAllById(Iterable<? extends String> strings) {
        throw new UnsupportedOperationException("Not supported yet.");
    }

    @Override
    public void deleteAll(Iterable<? extends Invoice> entities) {
        throw new UnsupportedOperationException("Not supported yet.");
    }

    @Override
    public void deleteAll() {
        throw new UnsupportedOperationException("Not supported yet.");
    }

    @Override
    public <S extends Invoice> Iterable<S> saveAll(Iterable<S> entities) {
        throw new UnsupportedOperationException("Not supported yet.");
    }

    @Override
    public Optional<Invoice> findById(String number) {

        throw new UnsupportedOperationException("Not supported yet.");
    }

    @Override
    public boolean existsById(String s) {
        return false;
    }
}
