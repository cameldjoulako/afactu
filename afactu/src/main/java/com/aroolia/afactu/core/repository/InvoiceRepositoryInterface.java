package com.aroolia.afactu.core.repository;


import com.aroolia.afactu.core.entity.Invoice;
import org.springframework.data.repository.CrudRepository;
//import org.springframework.stereotype.Repository;

import java.util.List;

//@Repository
public interface InvoiceRepositoryInterface extends CrudRepository<Invoice, String> {
    /*Invoice create(Invoice invoice);

    List<Invoice> list();

    Invoice getById(String number);*/
}