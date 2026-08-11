package com.aroolia.afactu.invoice.repository;


import com.aroolia.afactu.core.entity.invoice.Invoice;
import org.springframework.data.jpa.repository.EntityGraph;
import org.springframework.data.repository.CrudRepository;
//import org.springframework.stereotype.Repository;


//@Repository
public interface InvoiceRepositoryInterface extends CrudRepository<Invoice, String> {
}