package com.creditas.challenge.services;

import com.creditas.challenge.model.Order;
import com.creditas.challenge.model.OrderItem;
import com.creditas.challenge.model.PaymentMethod;
import com.creditas.challenge.model.Product;
import com.creditas.challenge.repositories.OrderRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class DefaultOrderService implements OrderService {

    @Autowired
    private OrderItemService orderItemService;

    @Autowired
    private ProductService productService;

    @Autowired
    private OrderRepository orderRepository;
/*
    @Autowired
    private OrderRepository orderRepository;

    @PersistenceContext(unitName="ProductService")
    EntityManager em;

 */

    @Override
    public Order saveOrder(Order order) {
        return orderRepository.save(order);
    }

    @Override
    public double totalAmount(Order order) {
        return order.getItems()
                .stream()
                .map(orderItem -> orderItemService.total(orderItem))
                .reduce(Double::sum)
                .orElse(0.0);
    }

    @Override
    public void addProduct(Order order, Product product, int quantity) {
        boolean productAlreadyAdded = order.getItems().stream().anyMatch(orderItem -> orderItem.getProduct() == product);
        if (productAlreadyAdded) {
            throw new RuntimeException("The product have already been added. Change the amount if you want more.");
        }
        Product productSaved = productService.saveProduct(product);
        OrderItem orderItemSaved = orderItemService.saveOrderItem(new OrderItem(productSaved, quantity));
        order.getItems().add(orderItemSaved);
        orderRepository.save(order);
    }

    @Override
    public void pay(PaymentMethod method) {

    }
}
