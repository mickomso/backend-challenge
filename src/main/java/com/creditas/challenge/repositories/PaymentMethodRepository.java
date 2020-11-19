package com.creditas.challenge.repositories;

import com.creditas.challenge.model.PaymentMethod;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface PaymentMethodRepository extends JpaRepository<PaymentMethod, Long>, CustomPaymentMethodRepository {
}
