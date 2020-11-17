package com.creditas.challenge.services;

import com.creditas.challenge.model.Customer;
import com.creditas.challenge.repositories.CustomerRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.Optional;

@Service
public class DefaultCustomerService implements CustomerService {

    @Autowired
    private CustomerRepository customerRepository;

    @Override
    public Customer saveCustomer(Customer customer) {
        return customerRepository.save(customer);
    }

    @Override
    public Customer createCustomer() {
        Customer customer = new Customer();
        return customerRepository.save(customer);
    }

    @Override
    public Optional<Customer> findById(Long id) {
        return customerRepository.findById(id);
    }
}