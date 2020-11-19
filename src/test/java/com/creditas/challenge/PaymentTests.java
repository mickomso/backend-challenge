package com.creditas.challenge;

import com.creditas.challenge.model.*;
import com.creditas.challenge.services.*;
import org.junit.After;
import org.junit.Before;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringRunner;

import java.util.Optional;

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertNotNull;

import org.slf4j.Logger;

@RunWith(SpringRunner.class)
@SpringBootTest
public class PaymentTests {

    Logger log = LoggerFactory.getLogger(PaymentTests.class);

    private Order newOrder;

    @Before
    public void init() {
        Optional<Customer> customer = customerService.findById(new Long(1L));
        Optional<Address> address = addressService.findById(new Long(1L));
        Order order = new Order();
        order.setAddress(address.get());
        order.setCustomer(customer.get());
        newOrder = orderService.saveOrder(order);

        orderService.addProduct(newOrder,new Product("Product 1", ProductType.DIGITAL, 10.0), 1);
    }

    @Test
    public void testPayment() {
        PaymentMethod paymentMethod = paymentMethodService.createPaymentMethod("123456789", PaymentMethodType.CREDIT_CARD);
        Double amount = orderService.totalAmount(newOrder);
        Payment newPayment = null;
        try {
            newPayment = paymentService.createPayment(newOrder, paymentMethod, amount);
        } catch (Exception e) {
            log.error(e.getMessage());
        }
        assertEquals(10,newPayment.getAmount(),0);
    }

    @After
    public void end() {
        orderService.deleteOrderCompletely(newOrder);
        paymentMethodService.deleteByNumber("123456789");
    }

    @Autowired
    private InvoiceService invoiceService;

    @Autowired
    private PaymentMethodService paymentMethodService;

    @Autowired
    private PaymentService paymentService;

    @Autowired
    private CustomerService customerService;

    @Autowired
    private AddressService addressService;

    @Autowired
    private OrderService orderService;
}
