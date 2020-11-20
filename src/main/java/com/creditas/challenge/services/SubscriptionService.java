package com.creditas.challenge.services;

import com.creditas.challenge.model.Customer;
import com.creditas.challenge.model.Subscription;

import java.util.List;

public interface SubscriptionService {

    public void createActiveSubscriptionAndSendEmail(Customer customer);

    public void userNotifiedByEmail(Subscription subscription, boolean notified);

    public List<Subscription> findByCustomer(Customer customer);
}
