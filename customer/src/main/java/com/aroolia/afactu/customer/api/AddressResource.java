package com.aroolia.afactu.customer.api;

import com.aroolia.afactu.core.entity.customer.Address;
import com.aroolia.afactu.core.entity.customer.Customer;
import com.aroolia.afactu.customer.repository.AddressRepositoryInterface;
import com.aroolia.afactu.customer.repository.CustomerRepositoryInterface;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.server.ResponseStatusException;

import static java.lang.System.out;

@RestController
@RequestMapping("/address")
public class AddressResource {

    @Autowired
    private AddressRepositoryInterface adressRepository;

    @GetMapping("/{id}")
    public Address get(@PathVariable("id") Long id) {
        out.println("Recuperation d'un customer invoqué");

        return adressRepository.findById(id).orElseThrow(() -> new ResponseStatusException(HttpStatus.NOT_FOUND));
    }

    public AddressRepositoryInterface getAdressRepository() {
        return adressRepository;
    }

    public void setAdressRepository(AddressRepositoryInterface adressRepository) {
        this.adressRepository = adressRepository;
    }
}