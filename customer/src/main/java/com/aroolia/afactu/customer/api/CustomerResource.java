package com.aroolia.afactu.customer.api;

import com.aroolia.afactu.core.entity.customer.Customer;
import com.aroolia.afactu.core.entity.invoice.Invoice;

import com.aroolia.afactu.customer.repository.CustomerRepositoryInterface;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.HttpStatusCode;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.server.ResponseStatusException;

import java.util.List;
import java.util.stream.Collectors;
import java.util.stream.StreamSupport;

import static java.lang.System.out;

@RestController
@RequestMapping("/customer")
public class CustomerResource {

    @Autowired
    private CustomerRepositoryInterface customerRepository;

    @GetMapping("/{id}")
    public Customer get(@PathVariable("id") Long id) {
        out.println("Recuperation d'un customer invoqué");

        return customerRepository.findById(id).orElseThrow(() -> new ResponseStatusException(HttpStatus.NOT_FOUND));
    }

    public CustomerRepositoryInterface getCustomerRepository() {
        return customerRepository;
    }

    public void setCustomerRepository(CustomerRepositoryInterface customerRepository) {
        this.customerRepository = customerRepository;
    }

}