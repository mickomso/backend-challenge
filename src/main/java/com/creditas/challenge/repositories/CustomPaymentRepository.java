package com.creditas.challenge.repositories;

import com.creditas.challenge.model.Order;
import org.springframework.data.jpa.repository.Modifying;
import org.springframework.data.jpa.repository.Query;
import org.springframework.transaction.annotation.Transactional;

public interface CustomPaymentRepository {

    @Modifying
    @Transactional
    @Query("DELETE FROM Payment WHERE order = :order")
    public void deleteByOrder(Order order);
}
