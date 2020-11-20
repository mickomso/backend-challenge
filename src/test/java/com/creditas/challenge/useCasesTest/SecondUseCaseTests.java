package com.creditas.challenge.useCasesTest;

import com.creditas.challenge.Challenge;
import com.creditas.challenge.model.*;
import com.creditas.challenge.services.*;
import org.junit.After;
import org.junit.Before;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringRunner;

import java.util.List;

import static org.junit.Assert.assertTrue;

/**
 *
 * SECOND USE CASE:
 *
 *   Second Use Case: If payment is a service subscription, you must activate the subscription,
 *   and notify the user via email about this.
 *
 **/
@RunWith(SpringRunner.class)
@SpringBootTest
public class SecondUseCaseTests {

    private Logger log = LoggerFactory.getLogger(SecondUseCaseTests.class);
    private Order order;

    @Before
    public void execute() throws Exception {
        log.info("\nStarting the second use case...");
        Address address = createAddress();
        Customer customer = createCustomer();
        order = orderService.createOrder(customer, address);
        List<Product> membershipProducts = productService.findByType(ProductType.MEMBERSHIP);
        orderService.addProduct(order, membershipProducts.get(0), 1);

        PaymentMethod paymentMethod = paymentMethodService.createPaymentMethod("1234", PaymentMethodType.CREDIT_CARD);
        paymentService.createPayment(order, paymentMethod, orderService.totalAmount(order));
    }

    @Test
    public void testSubscriptionIsCreatedForCustomer() {
        List<Subscription> subscriptions = subscriptionService.findByCustomer(order.getCustomer());
        subscriptions.stream().forEach(subscription -> log.info(subscription.toString()));
        assertTrue(subscriptions.size() == 1);
    }

    @After
    public void end() {
        log.info("\nThe second use case has finished.");
    }

    private Customer createCustomer() {
        return customerService.createCustomer("Miguel", "Company", "migcom@mail.com");
    }

    private Address createAddress() {
        return addressService.createAddress("Avenida Aragón", 100, "Valencia", "Spain", "46022");
    }

    @Autowired
    private PaymentMethodService paymentMethodService;

    @Autowired
    private CustomerService customerService;

    @Autowired
    private AddressService addressService;

    @Autowired
    private PaymentService paymentService;

    @Autowired
    private ProductService productService;

    @Autowired
    private OrderService orderService;

    @Autowired
    private SubscriptionService subscriptionService;
}
