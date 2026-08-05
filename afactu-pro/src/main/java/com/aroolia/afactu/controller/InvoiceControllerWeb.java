package com.aroolia.afactu.controller;

import com.aroolia.afactu.core.controller.InvoiceControllerInterface;
import com.aroolia.afactu.core.entity.Invoice;

import com.aroolia.afactu.core.service.InvoiceServiceInterface;
import com.aroolia.afactu.form.InvoiceForm;
import jakarta.validation.Valid;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.*;


import jakarta.servlet.http.HttpServletRequest;
import org.springframework.web.servlet.ModelAndView;

import java.util.List;

import static java.lang.System.*;

@Controller
@RequestMapping("/invoice")
public class InvoiceControllerWeb {

    @Autowired
    private InvoiceServiceInterface invoiceService;

    public InvoiceServiceInterface getInvoiceService() {
        return invoiceService;
    }

    public void setInvoiceService(InvoiceServiceInterface invoiceService) {
        this.invoiceService = invoiceService;
    }

    @PostMapping("/create")
    public String createInvoice(@Valid @ModelAttribute InvoiceForm invoiceForm, BindingResult bindingResult) {

        if (bindingResult.hasErrors()) {
            return "invoice-create-form";
        }
        Invoice invoice = new Invoice();
        invoice.setCustomerName(invoiceForm.getCustomerName());
        invoice.setOrderNumber(invoiceForm.getOrderNumber());

        invoiceService.createInvoice(invoice);

        return "invoice-created";
    }

    /*@RequestMapping("/home")
    public @ModelAttribute("invoices") List<Invoice> displayHome(HttpServletRequest request) {
        out.println("La méthode displayHome a été invoquée") ;
        List<Invoice> invoices = invoiceService.getInvoiceList() ;
        return invoices;
    }*/

    /*@RequestMapping("/home")
    public ModelAndView displayHome() {
        out.println("La méthode displayHome a été invoquée") ;

        ModelAndView mv = new ModelAndView("invoice-home");
        mv.addObject("invoices", invoiceService.getInvoiceList());

        return mv;
    }

    @RequestMapping("/{id}")
    public ModelAndView displayInvoice(@PathVariable("id") String number) {

        out.println("La méthode displayInvoice a été invoquée") ;
        ModelAndView mv = new ModelAndView("invoice-details");
        mv.addObject("invoice", invoiceService.getInvoiceByNumber(number));

        //List<Invoice> invoices = invoiceService.getInvoiceList() ;

        return mv;
    }*/

    @GetMapping("/home")
    public String displayHome(Model model) {
        out.println("La méthode displayHome a été invoquée") ;
        model.addAttribute("invoices", invoiceService.getInvoiceList());
        return "invoice-home";
    }

    /*@GetMapping("/{id}")
    public String displayInvoice(@PathVariable("id") String number, Model model) {

        out.println("La méthode displayInvoice a été invoquée") ;
        model.addAttribute("invoice", invoiceService.getInvoiceByNumber(number));
        //List<Invoice> invoices = invoiceService.getInvoiceList() ;

        return "invoice-details";
    }*/

    @GetMapping("/create-form")
    public String displayInvoiceCreateForm(@ModelAttribute InvoiceForm invoice) {
        return "invoice-create-form";
    }



}