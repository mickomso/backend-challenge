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
 * FOURTH USE CASE:
 *
 *   Fourth Use Case: If payment of any digital media (music, video),
 *   in addition to sending the description of the purchase by email to the buyer,
 *   grant a discount voucher of 10% to the buyer associated with the payment.
 *
 **/
@RunWith(SpringRunner.class)
@SpringBootTest
public class FourthUseCaseTests {

    private Logger log = LoggerFactory.getLogger(FourthUseCaseTests.class);
    private Order order;

    @Before
    public void execute() throws Exception {
        log.info("\nStarting the fourth use case...");
        Address address = createAddress();
        Customer customer = createCustomer();
        order = orderService.createOrder(customer, address);
        List<Product> digitalProducts = productService.findByType(ProductType.DIGITAL);
        orderService.addProduct(order, digitalProducts.get(0), 1);

        PaymentMethod paymentMethod = paymentMethodService.createPaymentMethod("8604", PaymentMethodType.CREDIT_CARD);
        paymentService.createPayment(order, paymentMethod, orderService.totalAmount(order));
    }

    @Test
    public void testDiscountIsCreatedForCustomer() {
        List<Discount> discounts = discountService.findByOrderAndCustomer(order);
        discounts.stream().forEach(discount -> log.info(discount.toString()));
        assertTrue(discounts.size()==1);
    }

    @After
    public void end() {
        log.info("\nThe fourth use case has finished.");
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
    private DiscountService discountService;
}
