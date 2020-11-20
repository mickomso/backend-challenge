package com.creditas.challenge.repositories;

import com.creditas.challenge.model.Order;
import org.springframework.data.jpa.repository.Modifying;
import org.springframework.data.jpa.repository.Query;
import org.springframework.transaction.annotation.Transactional;

public interface CustomShippingLabelRepository {

    @Modifying
    @Transactional
    @Query("DELETE FROM ShippingLabel WHERE order = :order")
    public void deleteByOrder(Order order);
}
