package com.codecool.advance.demosecuirty.repository;

import com.codecool.advance.demosecuirty.model.Customer;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.Optional;
import java.util.UUID;

public interface CustomerRepository extends JpaRepository<Customer, UUID> {

    Optional<Customer> findCustomerByUsername(String username);

}
