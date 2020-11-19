package com.creditas.challenge.services;


import com.creditas.challenge.model.PaymentMethod;
import com.creditas.challenge.model.PaymentMethodType;

public interface PaymentMethodService {

    public PaymentMethod createPaymentMethod(String number, PaymentMethodType type);

    public void deleteByNumber(String number);
}
