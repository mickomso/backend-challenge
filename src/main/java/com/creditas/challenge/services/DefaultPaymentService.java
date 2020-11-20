package com.creditas.challenge.services;

import com.creditas.challenge.model.*;
import com.creditas.challenge.repositories.PaymentRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.stream.Collectors;

@Service
public class DefaultPaymentService implements PaymentService {

    @Override
    public Payment createPayment(Order order, PaymentMethod paymentMethod, Double amount) throws Exception {

        List<OrderItem> items = order.getItems();

        if (items.isEmpty()) {
            throw new Exception("ERROR: The order has no items added. The payment can not be done.");
        }

        List<OrderItem> physicalItems = items.stream().filter(orderItem -> orderItem.getProduct().getType().equals(ProductType.PHYSICAL)).collect(Collectors.toList());
        List<OrderItem> membershipItems = items.stream().filter(orderItem -> orderItem.getProduct().getType().equals(ProductType.MEMBERSHIP)).collect(Collectors.toList());
        List<OrderItem> bookItems = items.stream().filter(orderItem -> orderItem.getProduct().getType().equals(ProductType.BOOK)).collect(Collectors.toList());
        List<OrderItem> digitalItems = items.stream().filter(orderItem -> orderItem.getProduct().getType().equals(ProductType.DIGITAL)).collect(Collectors.toList());

        if (!physicalItems.isEmpty()) {
            physicalItems.stream().forEach(item -> shippingLabelService.createShippingLabel(order, item.getProduct()));
        }
        if (!membershipItems.isEmpty()) {
            membershipItems.stream().forEach(item -> subscriptionService.createActiveSubscriptionAndSendEmail(order.getCustomer()));
        }
        if(!bookItems.isEmpty()) {

        }
        if(!digitalItems.isEmpty()) {

        }

        Order orderClosed = orderService.close(order);
        Payment payment = new Payment(orderClosed, paymentMethod, amount);
        return paymentRepository.save(payment);
    }

    @Override
    public void deletePaymentByOrder(Order order) {
        paymentRepository.deleteByOrder(order);
    }

    @Autowired
    private PaymentRepository paymentRepository;

    @Autowired
    private OrderService orderService;

    @Autowired
    private ShippingLabelService shippingLabelService;

    @Autowired
    private SubscriptionService subscriptionService;
}
