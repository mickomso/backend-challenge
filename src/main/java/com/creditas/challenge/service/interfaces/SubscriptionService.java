package com.creditas.challenge.service.interfaces;

import com.creditas.challenge.model.Customer;
import com.creditas.challenge.model.Subscription;

import java.util.List;

public interface SubscriptionService {

    /**
     * Creates and saves a new subscription. If so, calls the method to send an email.
     * @param customer
     */
    public void createActiveSubscriptionAndSendEmail(Customer customer);

    /**
     * Assigns a boolean value to the corresponding field,
     * indicating that an email has been sent to the customer.
     * @param subscription
     * @param notified
     */
    public void userNotifiedByEmail(Subscription subscription, boolean notified);

    /**
     * Finds the collection of subscriptions assigned to a customer.
     * @param customer
     * @return a list of subscriptions for the customer
     */
    public List<Subscription> findByCustomer(Customer customer);
}
