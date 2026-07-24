package com.aroolia.afactu.repository;


import com.aroolia.afactu.entity.Invoice;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface InvoiceRepositoryInterface {
    void create(Invoice invoice);

    List<Invoice> list();
}