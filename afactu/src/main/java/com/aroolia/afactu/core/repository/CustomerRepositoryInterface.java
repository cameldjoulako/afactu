package com.aroolia.afactu.core.repository;

import com.aroolia.afactu.core.entity.Customer;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.repository.CrudRepository;

import java.util.Optional;

/*
public interface CustomerRepositoryInterface extends JpaRepository<Customer, Long> {
    Optional<Customer> findByName(String name);
}*/

public interface CustomerRepositoryInterface extends CrudRepository<Customer, Long> {
    //Optional<Customer> findByName(String name);
}
