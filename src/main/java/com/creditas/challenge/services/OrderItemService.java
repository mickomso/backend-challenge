package com.creditas.challenge.services;

import com.creditas.challenge.model.OrderItem;

public interface OrderItemService {

    public double total(OrderItem orderItem);

    public OrderItem saveOrderItem(OrderItem orderItem);
}
