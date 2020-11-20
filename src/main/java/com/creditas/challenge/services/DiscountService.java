package com.creditas.challenge.services;

import com.creditas.challenge.model.Customer;
import com.creditas.challenge.model.Discount;
import com.creditas.challenge.model.Order;

import java.util.List;

public interface DiscountService {

    public void createDiscount(Customer customer, Double discount) throws Exception;

    public List<Discount> findByOrderAndCustomer(Order order);
}
