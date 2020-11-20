package com.creditas.challenge.services;

import com.creditas.challenge.model.Customer;

import java.util.Optional;

public interface CustomerService {

    public Customer saveCustomer(Customer customer);

    public Customer createCustomer(String firstName, String lastName, String email);

    public Optional<Customer> findById(Long id);
}
