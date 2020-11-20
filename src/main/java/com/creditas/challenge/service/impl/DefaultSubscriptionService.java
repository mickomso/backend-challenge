package com.creditas.challenge.service.impl;

import com.creditas.challenge.model.Customer;
import com.creditas.challenge.model.Subscription;
import com.creditas.challenge.repository.SubscriptionRepository;
import com.creditas.challenge.service.interfaces.SubscriptionService;
import com.creditas.challenge.service.interfaces.CustomerService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class DefaultSubscriptionService implements SubscriptionService {

    @Override
    public void createActiveSubscriptionAndSendEmail(Customer customer) {
        Subscription subscription = new Subscription(customer, true);
        Subscription subscriptionSaved = subscriptionRepository.save(subscription);
        customerService.sendEmail(customer, "Subscription activated", "The subscription " + subscriptionSaved.getId() + " has been activated...");
        this.userNotifiedByEmail(subscriptionSaved,true);
    }

    @Override
    public void userNotifiedByEmail(Subscription subscription, boolean notified) {
        subscription.setUserNotified(notified);
        subscriptionRepository.save(subscription);
    }

    @Override
    public List<Subscription> findByCustomer(Customer customer) {
        return subscriptionRepository.findByCustomer(customer);
    }

    @Autowired
    private SubscriptionRepository subscriptionRepository;

    @Autowired
    private CustomerService customerService;
}
