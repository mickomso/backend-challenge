package com.creditas.challenge.services;

import com.creditas.challenge.model.*;
import com.creditas.challenge.repositories.OrderRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.Date;

@Service
public class DefaultOrderService implements OrderService {

    @Autowired
    private OrderItemService orderItemService;

    @Autowired
    private ProductService productService;

    @Autowired
    private OrderRepository orderRepository;

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
        if (!order.getItems().isEmpty()) {
            boolean productAlreadyAdded = order.getItems().stream().anyMatch(orderItem -> orderItem.getProduct() == product);
            if (productAlreadyAdded) {
                throw new RuntimeException("The product have already been added. Change the amount if you want more.");
            }
        }
        Product productSaved = productService.saveProduct(product);
        OrderItem orderItemSaved = orderItemService.saveOrderItem(new OrderItem(productSaved, quantity));
        order.getItems().add(orderItemSaved);
        orderRepository.save(order);
    }

    @Override
    public Order close(Order order) {
        // Creates the invoice associated to the payment
        // and updates the order
        Invoice newInvoice = invoiceService.createInvoice(order);
        order.setClosedAt(new Date());

        // Saves the completed order
        return orderRepository.save(order);
    }

    @Autowired
    private InvoiceService invoiceService;
}
