package com.creditas.challenge.repositories;

import com.creditas.challenge.model.Subscription;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface SubscriptionRepository extends JpaRepository<Subscription, Long>, CustomSubscriptionRepository {
}