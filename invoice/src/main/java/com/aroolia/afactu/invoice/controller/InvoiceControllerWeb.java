package com.aroolia.afactu.controller;

import com.aroolia.afactu.core.entity.customer.Address;
import com.aroolia.afactu.core.entity.customer.Customer;
import com.aroolia.afactu.core.entity.invoice.Invoice;
import com.aroolia.afactu.core.repository.CustomerRepositoryInterface;
import com.aroolia.afactu.core.service.InvoiceServiceInterface;
import com.aroolia.afactu.form.InvoiceForm;
import jakarta.validation.Valid;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.*;

import static java.lang.System.*;

@Controller
@RequestMapping("/invoice")
public class InvoiceControllerWeb {

    @Autowired
    private InvoiceServiceInterface invoiceService;

    @Autowired
    private CustomerRepositoryInterface customerRepository;

    @PostMapping("/create")
    public String createInvoice(@Valid @ModelAttribute InvoiceForm invoiceForm, BindingResult bindingResult) {

        if (bindingResult.hasErrors()) {
            return "invoice-create-form";
        }

        /*Customer customer = customerRepository.findByName(invoiceForm.getCustomerName())
                .orElseGet(() -> {
                    Address address = new Address(
                            invoiceForm.getStreet(),
                            invoiceForm.getStreetNumber(),
                            invoiceForm.getCity(),
                            invoiceForm.getZipCode(),
                            invoiceForm.getCountry()
                    );

                    Customer newCustomer = new Customer(invoiceForm.getCustomerName());
                    newCustomer.setAddress(address);

                    return customerRepository.save(newCustomer);
                });*/



        Invoice invoice = new Invoice();
        Customer customer  = new Customer(invoiceForm.getCustomerName());
        invoice.setCustomer(customer);

        Address address = new Address(invoiceForm.getStreet(), invoiceForm.getStreetNumber() , invoiceForm.getZipCode(), invoiceForm.getCity(), invoiceForm.getCountry());

        customer.setAddress(address);

        invoice.setOrderNumber(invoiceForm.getOrderNumber());

        invoiceService.createInvoice(invoice);

        return "invoice-created";
    }

    @GetMapping("/home")
    public String displayHome(Model model) {
        out.println("La méthode displayHome a été invoquée");
        model.addAttribute("invoices", invoiceService.getInvoiceList());
        return "invoice-home";
    }

    @GetMapping("/create-form")
    public String displayInvoiceCreateForm(@ModelAttribute InvoiceForm invoice) {
        return "invoice-create-form";
    }
}