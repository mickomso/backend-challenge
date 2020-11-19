package com.creditas.challenge;

import com.creditas.challenge.model.PaymentMethod;
import com.creditas.challenge.model.PaymentMethodType;
import com.creditas.challenge.services.PaymentMethodService;
import org.junit.After;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringRunner;

import static org.junit.Assert.*;

@RunWith(SpringRunner.class)
@SpringBootTest
public class PaymentMethodTests {

    @Test
    public void testCreatePaymentMethodWithExistingPaymentMethodType() {
        PaymentMethod paymentMethodCreated = paymentMethodService.createPaymentMethod("123456789", PaymentMethodType.CREDIT_CARD);
        assertNotNull(paymentMethodCreated.getId() != null);
    }

    @After
    public void end() {
        paymentMethodService.deleteByNumber("123456789");
    }

    @Autowired
    private PaymentMethodService paymentMethodService;
}
