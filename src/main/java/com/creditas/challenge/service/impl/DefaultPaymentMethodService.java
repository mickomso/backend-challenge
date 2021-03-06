package com.creditas.challenge.service.impl;

import com.creditas.challenge.model.CreditCard;
import com.creditas.challenge.model.PaymentMethod;
import com.creditas.challenge.model.PaymentMethodType;
import com.creditas.challenge.repository.PaymentMethodRepository;
import com.creditas.challenge.service.interfaces.PaymentMethodService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class DefaultPaymentMethodService implements PaymentMethodService {

    @Override
    public PaymentMethod createPaymentMethod(String number, PaymentMethodType type) {
        PaymentMethod paymentMethod = null;
        if (type.equals(PaymentMethodType.CREDIT_CARD)) {
            paymentMethod = paymentMethodRepository.save(new CreditCard(number));
        }
        return paymentMethod;
    }

    @Override
    public void deleteByNumber(String number) {
        paymentMethodRepository.deleteByNumber(number);
    }

    @Autowired
    private PaymentMethodRepository paymentMethodRepository;
}
