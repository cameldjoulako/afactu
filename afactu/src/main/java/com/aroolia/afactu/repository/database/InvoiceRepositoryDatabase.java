package com.aroolia.afactu.repository.database;


import com.aroolia.afactu.entity.Invoice;
import com.aroolia.afactu.repository.InvoiceRepositoryInterface;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public class InvoiceRepositoryDatabase implements InvoiceRepositoryInterface {

    public void create(Invoice invoice) {
        /*[…]
        PreparedStatement pstmt = connexion.prepareStatement("INSERT INTO FACTURE (NUMBER,CUSTOMERNAME) VALUES (?,?)");
                […]
        pstmt.executeUpdate();*/

        System.out.println("Database: Invoice added with number " + invoice.getNumber() + " for " + invoice.getCustomerName());
    }

    @Override
    public List<Invoice> list() {
        Invoice invoice1 = new Invoice();
        invoice1.setNumber("NUM_1");
        invoice1.setCustomerName("Gate Corp");

        Invoice invoice2 = new Invoice();
        invoice2.setNumber("NUM_2");
        invoice2.setCustomerName("Alpha Metal");

        return List.of(invoice1, invoice2);
    }
}