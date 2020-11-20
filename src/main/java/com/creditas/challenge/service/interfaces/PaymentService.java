package com.creditas.challenge.service.interfaces;

import com.creditas.challenge.model.Order;
import com.creditas.challenge.model.Payment;
import com.creditas.challenge.model.PaymentMethod;

public interface PaymentService {

    /**
     * Creates and saves a payment entity
     * @param order
     * @param paymentMethod
     * @param amount
     * @return the payment entity saved
     * @throws Exception
     */
    public Payment createPayment(Order order, PaymentMethod paymentMethod, Double amount) throws Exception;

    /**
     * Deletes a payment by its associated order
     * @param order
     */
    public void deletePaymentByOrder(Order order);
}
