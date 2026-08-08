package com.aroolia.afactu.api;

import com.aroolia.afactu.core.entity.Invoice;
import com.aroolia.afactu.core.service.InvoiceServiceInterface;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.stream.StreamSupport;
import java.util.stream.Collectors;

import java.util.List;

import static java.lang.System.out;

@RestController
@RequestMapping("/invoice")
public class InvoiceResource {

    @Autowired
    private InvoiceServiceInterface invoiceService;

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
        return invoiceService.getInvoiceByNumber(number);
    }

    /*@GetMapping
    public List<Invoice> list() {
        out.println("La méthode display all invoice  a été invoquée");
        return invoiceService.getInvoiceList();
    }*/

    @GetMapping
    public List<Invoice> list() {
        out.println("La méthode display all invoice a été invoquée");
        Iterable<Invoice> invoices = invoiceService.getInvoiceList();
        return StreamSupport.stream(invoices.spliterator(), false)
                .collect(Collectors.toList());
    }
}