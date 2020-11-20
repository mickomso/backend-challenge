package com.creditas.challenge.services;

import com.creditas.challenge.model.Order;
import com.creditas.challenge.model.Product;
import com.creditas.challenge.model.ProductType;

import java.util.List;
import java.util.Optional;

public interface ProductService {

    public Product saveProduct(Product product);

    public Optional<Product> findById(Long id);

    public List<Product> findByOrderAndType(Order order, ProductType type);

    public List<Product> findByType(ProductType type);
}
