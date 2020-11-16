package com.creditas.challenge.services;

import com.creditas.challenge.model.PaymentMethod;
import com.creditas.challenge.model.Product;

public interface OrderService {

    public double totalAmount();

    public void addProduct(Product product, int quantity);

    public void pay(PaymentMethod method);
}
