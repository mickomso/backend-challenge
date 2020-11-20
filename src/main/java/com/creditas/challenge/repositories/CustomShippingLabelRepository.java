package com.creditas.challenge.repositories;

import com.creditas.challenge.model.Order;
import com.creditas.challenge.model.Product;
import com.creditas.challenge.model.ShippingLabel;
import org.springframework.data.jpa.repository.Modifying;
import org.springframework.data.jpa.repository.Query;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;

public interface CustomShippingLabelRepository {

    @Modifying
    @Transactional
    @Query("DELETE FROM ShippingLabel WHERE order = :order")
    public void deleteByOrder(Order order);

    @Query("SELECT sh FROM ShippingLabel sh WHERE sh.order = :order")
    public List<ShippingLabel> findByOrder(Order order);
}
