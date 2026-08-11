package com.aroolia.afactu.invoice.api;//package com.aroolia.afactu.api;

import com.aroolia.afactu.core.entity.customer.Address;
import com.aroolia.afactu.core.entity.customer.Customer;
import com.aroolia.afactu.core.entity.invoice.Invoice;
import com.aroolia.afactu.invoice.service.InvoiceServiceInterface;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.client.RestTemplate;

import java.util.stream.StreamSupport;
import java.util.stream.Collectors;

import java.util.List;

import static java.lang.System.out;

@RestController
@RequestMapping("/invoice")
public class InvoiceResource {

    @Autowired
    private InvoiceServiceInterface invoiceService;

    @Autowired
    private RestTemplate restTemplate;

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

    @GetMapping("/{id}")
    public Invoice get(@PathVariable("id") String number) {
        out.println("La méthode displayInvoice a été invoquée");
         Invoice invoice = invoiceService.getInvoiceByNumber(number);

         final Customer customer = restTemplate.getForObject("http://customer-service/customer/"+invoice.getIdCustomer(), Customer.class) ;


         final Address address = restTemplate.getForObject("http://customer-service/address/"+customer.getAddress().getId(), Address.class) ;

         customer.setAddress(address);
         invoice.setCustomer(customer);

         return invoice;
    }

    /*@GetMapping
    public List<Invoice> list() {
        out.println("La méthode display all invoice  a été invoquée");
        return invoiceService.getInvoiceList();
    }*/

    @GetMapping
    public Iterable<Invoice> list() {
        out.println("La méthode display all invoice a été invoquée");
        Iterable<Invoice> invoices = invoiceService.getInvoiceList();

        invoices.forEach(invoice -> {
            invoice.setCustomer(restTemplate.getForObject("http://customer-service/customer/"+invoice.getIdCustomer(), Customer.class) );
        } );

        return invoices;
    }
}