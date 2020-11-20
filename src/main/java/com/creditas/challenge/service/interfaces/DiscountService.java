package com.creditas.challenge.service.interfaces;

import com.creditas.challenge.model.Customer;
import com.creditas.challenge.model.Discount;
import com.creditas.challenge.model.Order;

import java.util.List;

public interface DiscountService {

    /**
     * Creates and saves a discount entity
     * @param customer
     * @param discount
     * @throws Exception
     */
    public void createDiscount(Customer customer, Double discount) throws Exception;

    /**
     * Finds a discount entity associated to an order and customer
     * @param order
     * @return a collection of discount objects
     */
    public List<Discount> findByOrderAndCustomer(Order order);
}
