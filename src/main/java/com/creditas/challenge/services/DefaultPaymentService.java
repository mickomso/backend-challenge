package com.creditas.challenge.services;

import com.creditas.challenge.model.Order;
import com.creditas.challenge.model.Payment;
import com.creditas.challenge.model.PaymentMethod;
import com.creditas.challenge.repositories.PaymentRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class DefaultPaymentService implements PaymentService {

    @Override
    public Payment createPayment(Order order, PaymentMethod paymentMethod, Double amount) throws Exception {
        if (order.getItems().size() > 0) {
            orderService.findPhysicalProductsByOrderAndCreateShippingLabel(order);
            Order orderClosed = orderService.close(order);
            Payment payment = new Payment(orderClosed, paymentMethod, amount);
            return paymentRepository.save(payment);
        } else {
            throw new Exception("ERROR: The order has no items added. The payment can not be done.");
        }
    }

    @Override
    public void deletePaymentByOrder(Order order) {
        paymentRepository.deleteByOrder(order);
    }

    @Autowired
    private PaymentRepository paymentRepository;

    @Autowired
    private OrderService orderService;
}
