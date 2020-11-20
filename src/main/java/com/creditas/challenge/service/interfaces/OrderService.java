package com.creditas.challenge.service.interfaces;

import com.creditas.challenge.model.*;

public interface OrderService {

    /**
     * Creates and saves an order
     * @param order
     * @return the saved Order
     */
    public Order saveOrder(Order order);

    /**
     * Calculates the total amount of an order
     * @param order
     * @return the multiplication of the price and the quantity of each product
     */
    public double totalAmount(Order order);


    /**
     * Adds a product to an order
     * @param order
     * @param product
     * @param quantity
     * @return
     */
    public Product addProduct(Order order, Product product, int quantity);

    /**
     * Closes an order when it is going to be paid
     * @param order
     * @return the closed order
     */
    public Order close(Order order);

    /**
     * Removes an order an its corresponding subelements.
     * @param order
     */
    public void deleteOrderCompletely(Order order);

    /**
     * Creates and saves an order.
     * @param customer
     * @param address
     * @return an order saved.
     */
    public Order createOrder(Customer customer, Address address);
}
