package com.creditas.challenge.repositories;

import com.creditas.challenge.model.Customer;
import com.creditas.challenge.model.Subscription;
import org.springframework.data.jpa.repository.Query;

import java.util.List;

public interface CustomSubscriptionRepository {

    @Query("SELECT s FROM Subscription s WHERE s.customer = :customer")
    public List<Subscription> findByCustomer(Customer customer);
}
