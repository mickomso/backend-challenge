package com.creditas.challenge.useCasesTest;

import com.creditas.challenge.model.*;
import com.creditas.challenge.service.interfaces.*;
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
 * THIRD USE CASE:
 *
 *   Third Use Case: If the payment is an ordinary book,
 *   you must generate a shipping label with a notification that it is a tax-exempt item.
 *
 **/
@RunWith(SpringRunner.class)
@SpringBootTest
public class ThirdUseCaseTests {

    private Logger log = LoggerFactory.getLogger(ThirdUseCaseTests.class);
    private Order order;

    @Before
    public void execute() throws Exception {
        log.info("\nStarting the third use case...");
        Address address = createAddress();
        Customer customer = createCustomer();
        order = orderService.createOrder(customer, address);
        List<Product> bookProducts = productService.findByType(ProductType.BOOK);
        orderService.addProduct(order, bookProducts.get(0), 1);

        PaymentMethod paymentMethod = paymentMethodService.createPaymentMethod("3456", PaymentMethodType.CREDIT_CARD);
        paymentService.createPayment(order, paymentMethod, orderService.totalAmount(order));
    }

    @Test
    public void testSubscriptionIsCreatedForCustomer() {
        List<ShippingLabel> shippingLabels = shippingLabelService.findByOrder(order);
        shippingLabels.stream().forEach(shippingLabel -> log.info(shippingLabel.toString()));
        assertTrue(shippingLabels.size()==1);
    }

    @After
    public void end() {
        log.info("\nThe third use case has finished.");
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
    private ShippingLabelService shippingLabelService;
}
