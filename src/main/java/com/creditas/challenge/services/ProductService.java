package com.creditas.challenge.services;

import com.creditas.challenge.model.Product;

import java.util.Optional;

public interface ProductService {

    public Product saveProduct(Product product);

    public Optional<Product> findById(Long id);
}
