package com.creditas.challenge.services;

import com.creditas.challenge.model.*;

import java.util.Optional;

public interface ShippingLabelService {

    /**
     * Creates and saves a shipping label
     * @param order
     * @param product
     * @return the saved shipping label
     */
    public ShippingLabel createShippingLabel(Order order, Product product);

    /**
     * Prints the shipping label received
     * @param shippingLabel
     */
    public void printShippingLabel(ShippingLabel shippingLabel);

    /**
     * Deletes a shipping label associated to an order
     * @param order
     */
    public void deleteByOrder(Order order);


    /**
     * Finds a shipping label by its id attribute
     * @param id
     * @return an optional object with the shipping label found or an empty optional if not
     */
    public Optional<ShippingLabel> findById(Long id);
}