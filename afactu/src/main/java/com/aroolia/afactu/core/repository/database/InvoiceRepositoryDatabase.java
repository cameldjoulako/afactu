package com.aroolia.afactu.core.repository.database;


import com.aroolia.afactu.core.entity.Invoice;
import com.aroolia.afactu.core.repository.InvoiceRepositoryInterface;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.jdbc.support.GeneratedKeyHolder;
import org.springframework.jdbc.support.KeyHolder;
import org.springframework.stereotype.Repository;

import java.sql.PreparedStatement;
import java.sql.Statement;
import java.util.List;

@Repository
public class InvoiceRepositoryDatabase implements InvoiceRepositoryInterface {

    @Autowired
    private JdbcTemplate jdbcTemplate;

    public Invoice create(Invoice invoice) {

        //INSERT WITH JdbcTemplate
        KeyHolder kh = new GeneratedKeyHolder();
        jdbcTemplate.update(connexion  -> {

            PreparedStatement ps = connexion.prepareStatement("INSERT INTO INVOICE(CUSTOMER_NAME, ORDER_NUMBER) VALUES (?, ?)",
                    Statement.RETURN_GENERATED_KEYS);
            ps.setString(1, invoice.getCustomerName());
            ps.setString(2, invoice.getOrderNumber());

            return ps;
        }, kh);

        invoice.setNumber(kh.getKey().toString());

        return invoice;
        /*[…]
        PreparedStatement pstmt = connexion.prepareStatement("INSERT INTO FACTURE (NUMBER,CUSTOMERNAME) VALUES (?,?)");
                […]
        pstmt.executeUpdate();*/

        /*System.out.println("Database: Invoice added with number " + invoice.getNumber() + " for " + invoice.getCustomerName());*/
    }

    @Override
    public List<Invoice> list() {

        return jdbcTemplate.query("SELECT INVOICE_NUMBER, CUSTOMER_NAME FROM INVOICE",
                (rs, rowNum) -> new Invoice(String.valueOf(rs.getLong("INVOICE_NUMBER")), rs.getString("CUSTOMER_NAME") ));



        /*Invoice invoice1 = new Invoice();
        invoice1.setNumber("NUM_1");
        invoice1.setCustomerName("Gate Corp");

        Invoice invoice2 = new Invoice();
        invoice2.setNumber("NUM_2");
        invoice2.setCustomerName("Alpha Metal");

        return List.of(invoice1, invoice2);*/
    }

    @Override
    public Invoice getById(String number) {

        return jdbcTemplate.queryForObject("SELECT INVOICE_NUMBER, CUSTOMER_NAME, ORDER_NUMBER FROM INVOICE WHERE INVOICE_NUMBER = ?",
                new Object[]{number},
                (rs, rowNum) -> new Invoice(String.valueOf(rs.getLong("INVOICE_NUMBER")),
                        rs.getString("CUSTOMER_NAME"), rs.getString("ORDER_NUMBER") ));

        /*Invoice invoice1 = new Invoice();
        invoice1.setNumber(number);
        invoice1.setCustomerName("Camel Djoulako");
        invoice1.setOrderNumber("ON_002");

        return invoice1;*/
    }
}