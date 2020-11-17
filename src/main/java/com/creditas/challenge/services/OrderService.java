package com.creditas.challenge.services;

import com.creditas.challenge.model.Order;
import com.creditas.challenge.model.PaymentMethod;
import com.creditas.challenge.model.Product;

public interface OrderService {

    public Order saveOrder(Order order);

    public double totalAmount(Order order);

    public void addProduct(Order order, Product product, int quantity);

    public void pay(PaymentMethod method);
}
