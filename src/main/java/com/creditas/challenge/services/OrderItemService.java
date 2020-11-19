package com.creditas.challenge.services;

import com.creditas.challenge.model.Order;
import com.creditas.challenge.model.OrderItem;

import java.util.List;

public interface OrderItemService {

    public double total(OrderItem orderItem);

    public OrderItem saveOrderItem(OrderItem orderItem);

    public void deleteOrderItemsByOrder(Order order);
}
