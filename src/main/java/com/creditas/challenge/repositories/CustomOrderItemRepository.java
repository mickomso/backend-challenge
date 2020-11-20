package com.creditas.challenge.repositories;

import com.creditas.challenge.model.Order;
import com.creditas.challenge.model.OrderItem;
import org.springframework.data.jpa.repository.Query;

import java.util.List;

public interface CustomOrderItemRepository {

    @Query("SELECT item FROM OrderItem item, Order ordr " +
            "WHERE ordr.id = item.order AND item.order = :order")
    public List<OrderItem> findByOrder(Order order);
}
