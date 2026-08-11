package com.aroolia.afactu.invoice.controller;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;

import static java.lang.System.out;

@Controller
public class InvoiceControllerWeb {
    /*@Autowired
    private InvoiceServiceInterface invoiceService;

    @Autowired
    private CustomerRepositoryInterface customerRepository;

    @PostMapping("/create")
    public String createInvoice(@Valid @ModelAttribute InvoiceForm invoiceForm, BindingResult bindingResult) {

        if (bindingResult.hasErrors()) {
            return "invoice-create-form";
        }

        Invoice invoice = new Invoice();
        Customer customer  = new Customer(invoiceForm.getCustomerName());
        invoice.setCustomer(customer);

        Address address = new Address(invoiceForm.getStreet(), invoiceForm.getStreetNumber() , invoiceForm.getZipCode(), invoiceForm.getCity(), invoiceForm.getCountry());

        customer.setAddress(address);

        invoice.setOrderNumber(invoiceForm.getOrderNumber());

        invoiceService.createInvoice(invoice);

        return "invoice-created";
    }


    @GetMapping("/create-form")
    public String displayInvoiceCreateForm(@ModelAttribute InvoiceForm invoice) {
        return "invoice-create-form";
    }*/

    @GetMapping("/home")
    public String displayHome(Model model) {
        out.println("La méthode displayHome a été invoquée");
        return "invoice-home";
    }

}