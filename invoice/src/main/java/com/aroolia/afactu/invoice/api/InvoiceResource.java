package com.aroolia.afactu.invoice.api;

import com.aroolia.afactu.core.entity.customer.Address;
import com.aroolia.afactu.core.entity.customer.Customer;
import com.aroolia.afactu.core.entity.invoice.Invoice;
import com.aroolia.afactu.invoice.service.InvoiceServiceInterface;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.client.RestTemplate;

import java.util.ArrayList;
import java.util.List;

import static java.lang.System.out;

@RestController
@RequestMapping("/invoice")
public class InvoiceResource {

    @Autowired
    private InvoiceServiceInterface invoiceService;

    @Autowired
    private RestTemplate restTemplate;



    /*public InvoiceResource(InvoiceServiceInterface invoiceServiceInterface) {
        this.invoiceService = invoiceServiceInterface;
    }



    public InvoiceServiceInterface getInvoiceService() {
        return invoiceService;
    }

    public void setInvoiceService(InvoiceServiceInterface invoiceService) {
        this.invoiceService = invoiceService;
    }

    @PostMapping
    public Invoice create(@RequestBody Invoice invoice) {
        return invoiceService.createInvoice(invoice);
    }

    */

    @GetMapping("/{id}")
    public Invoice get(@PathVariable("id") String number) {
        out.println("La méthode displayInvoice a été invoquée");

        Invoice invoice = invoiceService.getInvoiceByNumber(number);

        String urlCustomerService = "http://localhost:8082/customer/";
        final Customer customer =  restTemplate.getForObject(urlCustomerService + invoice.getIdCustomer(), Customer.class);

        String urlAddressService = "http://localhost:8082/address/";
        final Address address =  restTemplate.getForObject(urlAddressService + customer.getAddress().getId(), Address.class);

        customer.setAddress(address);
        invoice.setCustomer(customer);

        return invoice;
    }


    @GetMapping
    public Iterable<Invoice> list() {
        out.println("La méthode display all invoice a été invoquée");


        /*return StreamSupport.stream(invoices.spliterator(), false).collect(Collectors.toList());*/

        Iterable <Invoice> invoices = invoiceService.getInvoiceList();

        invoices.forEach( invoice -> {

            String urlCustomerService = "http://localhost:8082/customer/";

            invoice.setCustomer(restTemplate.getForObject(urlCustomerService + invoice.getIdCustomer(), Customer.class));
        });

        return invoices;
    }

    public InvoiceServiceInterface getInvoiceService() {
        return invoiceService;
    }

    public void setInvoiceService(InvoiceServiceInterface invoiceService) {
        this.invoiceService = invoiceService;
    }

}