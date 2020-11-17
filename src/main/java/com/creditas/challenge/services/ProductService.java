package com.creditas.challenge.services;

import com.creditas.challenge.model.Order;
import com.creditas.challenge.model.Product;

import java.util.List;
import java.util.Optional;

public interface ProductService {

    public Product saveProduct(Product product);

    public List<Product> findAllProductsByOrder(Order order);

    public Optional<Product> findById(Long id);
}
