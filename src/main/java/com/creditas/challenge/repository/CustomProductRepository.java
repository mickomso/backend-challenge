package com.creditas.challenge.repository;

import com.creditas.challenge.model.Order;
import com.creditas.challenge.model.Product;
import com.creditas.challenge.model.ProductType;
import org.springframework.data.jpa.repository.Query;

import java.util.List;

public interface CustomProductRepository {

    @Query("SELECT pr FROM Product pr, OrderItem item, Order ordr " +
            "WHERE pr.id = item.product " +
            "AND ordr.id = item.order " +
            "AND item.order = :order AND pr.type = :type")
    public List<Product> findByOrderAndType(Order order, ProductType type);

    @Query("SELECT pr FROM Product pr WHERE pr.type = :type")
    public List<Product> findByType(ProductType type);
}
