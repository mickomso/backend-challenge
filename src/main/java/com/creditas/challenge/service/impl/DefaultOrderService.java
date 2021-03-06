package com.creditas.challenge.service.impl;

import com.creditas.challenge.model.*;
import com.creditas.challenge.repository.OrderRepository;
import com.creditas.challenge.service.interfaces.*;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.Date;
import java.util.List;

@Service
public class DefaultOrderService implements OrderService {

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
    public Product addProduct(Order order, Product product, int quantity) {
        if (!order.getItems().isEmpty()) {
            boolean productAlreadyAdded = order.getItems().stream().anyMatch(orderItem -> orderItem.getProduct() == product);
            if (productAlreadyAdded) {
                throw new RuntimeException("The product have already been added. Change the amount if you want more.");
            }
        }
        Product productSaved = productService.saveProduct(product);
        orderItemService.saveOrderItem(new OrderItem(order,productSaved, quantity));
        List<OrderItem> newListItems = orderItemService.findAllByOrder(order);
        order.setItems(newListItems);
        orderRepository.save(order);
        return productSaved;
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

    @Override
    public void deleteOrderCompletely(Order order) {
        shippingLabelService.deleteByOrder(order);
        orderItemService.deleteOrderItemsByOrder(order);
        invoiceService.deleteByOrder(order);
        paymentService.deletePaymentByOrder(order);
        orderRepository.delete(order);
    }

    @Override
    public Order createOrder(Customer customer, Address address) {
        Order order = new Order(customer,address);
        return orderRepository.save(order);
    }

    @Autowired
    private ShippingLabelService shippingLabelService;

    @Autowired
    private PaymentService paymentService;

    @Autowired
    private InvoiceService invoiceService;

    @Autowired
    private OrderItemService orderItemService;

    @Autowired
    private ProductService productService;

    @Autowired
    private OrderRepository orderRepository;
}
