package com.creditas.challenge.service.interfaces;

import com.creditas.challenge.model.Order;
import com.creditas.challenge.model.Product;
import com.creditas.challenge.model.ProductType;

import java.util.List;
import java.util.Optional;

public interface ProductService {

    /**
     * Saves a product entity
     * @param product
     * @return the entity product saved
     */
    public Product saveProduct(Product product);

    /**
     * Finds a product if exists by its id
     * @param id
     * @return an optional object with the product or nothing
     */
    public Optional<Product> findById(Long id);

    /**
     * Finds the corresponding type products associated to an order
     * @param order
     * @param type
     * @return a collection of products filtered by the type selected
     */
    public List<Product> findByOrderAndType(Order order, ProductType type);

    /**
     * Finds the products filtered by the type selected
     * @param type
     * @return a collection of products filtered by the type selected
     */
    public List<Product> findByType(ProductType type);
}
