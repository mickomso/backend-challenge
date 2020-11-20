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
    public Customer createCustomer(String firstName, String lastName, String email) {
        Customer customer = new Customer(firstName, lastName, email);
        return customerRepository.save(customer);
    }

    @Override
    public Optional<Customer> findById(Long id) {
        return customerRepository.findById(id);
    }

    @Override
    public void sendEmail(Customer customer, String subject, String body) {
        // TODO Not covered by this prototype
    }
}
