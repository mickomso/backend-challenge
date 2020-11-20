package com.creditas.challenge.service.interfaces;

import com.creditas.challenge.model.Customer;

import java.util.Optional;

public interface CustomerService {

    /**
     * Saves a customer entity
     * @param customer
     * @return the customer entity saved
     */
    public Customer saveCustomer(Customer customer);

    /**
     * Creates and saves a customer entity
     * @param firstName
     * @param lastName
     * @param email
     * @return the customer entity saved
     */
    public Customer createCustomer(String firstName, String lastName, String email);

    /**
     * Finds a customer if it exists by its id
     * @param id
     * @return an optional object with the customer entity or nothing
     */
    public Optional<Customer> findById(Long id);

    /**
     * Sends an email to the given customer with a custom subject and body content
     * @param customer
     * @param subject
     * @param body
     */
    public void sendEmail(Customer customer, String subject, String body);
}
