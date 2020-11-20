package com.creditas.challenge.service.interfaces;

import com.creditas.challenge.model.Order;
import com.creditas.challenge.model.OrderItem;

import java.util.List;

public interface OrderItemService {

    /**
     * Calculates the total amount of a order item
     * @param orderItem
     * @return the multiplication of the product price and the quantity
     */
    public double total(OrderItem orderItem);

    /**
     * Saves an order item entity
     * @param orderItem
     * @return the order item entity
     */
    public OrderItem saveOrderItem(OrderItem orderItem);

    /**
     * Deletes an order item entity by its associated order
     * @param order
     */
    public void deleteOrderItemsByOrder(Order order);

    /**
     * Finds all the order items by its associated order
     * @param order
     * @return a collection of order item entities
     */
    public List<OrderItem> findAllByOrder(Order order);
}
