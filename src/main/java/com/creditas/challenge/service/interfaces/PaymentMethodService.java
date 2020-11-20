package com.creditas.challenge.service.interfaces;


import com.creditas.challenge.model.PaymentMethod;
import com.creditas.challenge.model.PaymentMethodType;

public interface PaymentMethodService {

    /**
     * Creates and saves a payment entity
     * @param number
     * @param type
     * @return the payment entity saved
     */
    public PaymentMethod createPaymentMethod(String number, PaymentMethodType type);

    /**
     * Deletes a payment by its corresponding number attribute
     * @param number
     */
    public void deleteByNumber(String number);
}
