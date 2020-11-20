package com.creditas.challenge.services;

import com.creditas.challenge.model.Order;
import com.creditas.challenge.model.OrderItem;
import com.creditas.challenge.model.Product;

import java.util.List;

public interface OrderItemService {

    public double total(OrderItem orderItem);

    public OrderItem saveOrderItem(OrderItem orderItem);

    public void deleteOrderItemsByOrder(Order order);

    public OrderItem createOrderItem(Order order, Product product, int quantity);

    public List<OrderItem> findAllByOrder(Order order);
}
