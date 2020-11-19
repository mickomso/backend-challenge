package com.creditas.challenge.services;

import com.creditas.challenge.model.Order;
import com.creditas.challenge.model.Payment;
import com.creditas.challenge.model.PaymentMethod;

public interface PaymentService {

    public Payment createPayment(Order order, PaymentMethod paymentMethod, Double amount) throws Exception;
}
