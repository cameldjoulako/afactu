package com.aroolia.afactu.customer.api;

import com.aroolia.afactu.core.entity.customer.Address;
import com.aroolia.afactu.core.entity.customer.Customer;
import com.aroolia.afactu.customer.repository.AddressRepositoryInterface;
import com.aroolia.afactu.customer.repository.CustomerRepositoryInterface;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.server.ResponseStatusException;

import static java.lang.System.out;

@RestController
@RequestMapping("/address")
public class AddressResource {

    @Autowired
    private AddressRepositoryInterface addressRepository;

    @GetMapping("/{id}")
    public Address get(@PathVariable("id") Long id) {
        out.println("Recuperation d'un customer invoqué");

        return addressRepository.findById(id).orElseThrow(() -> new ResponseStatusException(HttpStatus.NOT_FOUND));
    }


    public AddressRepositoryInterface getAddressRepository() {
        return addressRepository;
    }

    public void setAddressRepository(AddressRepositoryInterface addressRepository) {
        this.addressRepository = addressRepository;
    }
}