package com.aroolia.afactu.core.repository;

import com.aroolia.afactu.core.entity.Customer;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.Optional;

public interface CustomerRepositoryInterface extends JpaRepository<Customer, Long> {
    Optional<Customer> findByName(String name);
}