package com.aroolia.afactu.customer.repository;

import com.aroolia.afactu.core.entity.customer.Customer;
import org.springframework.data.repository.CrudRepository;

/*
public interface CustomerRepositoryInterface extends JpaRepository<Customer, Long> {
    Optional<Customer> findByName(String name);
}*/

public interface CustomerRepositoryInterface extends CrudRepository<Customer, Long> {
    //Optional<Customer> findByName(String name);
}
