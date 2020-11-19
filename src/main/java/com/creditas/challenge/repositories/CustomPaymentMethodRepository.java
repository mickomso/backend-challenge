package com.creditas.challenge.repositories;

import org.springframework.data.jpa.repository.Modifying;
import org.springframework.data.jpa.repository.Query;
import org.springframework.transaction.annotation.Transactional;

public interface CustomPaymentMethodRepository {

    @Modifying
    @Transactional
    @Query("DELETE FROM PaymentMethod WHERE number = :number")
    public void deleteByNumber(String number);
}
