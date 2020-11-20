package com.creditas.challenge.services;

import com.creditas.challenge.model.Order;
import com.creditas.challenge.model.Product;
import com.creditas.challenge.model.ProductType;
import com.creditas.challenge.repositories.ProductRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class DefaultProductService implements ProductService {

    @Autowired
    private ProductRepository productRepository;

    @Override
    public Product saveProduct(Product product) {
        return productRepository.save(product);
    }

    @Override
    public Optional<Product> findById(Long id) {
        return productRepository.findById(id);
    }

    @Override
    public List<Product> findByOrderAndType(Order order, ProductType type) {
        return productRepository.findByOrderAndType(order,type);
    }

    @Override
    public List<Product> findByType(ProductType type) {
        return productRepository.findByType(type);
    }
}
