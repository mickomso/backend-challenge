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
 * FIRST USE CASE:
 *
 *   First Use Case: If the payment is for a physical item, you must generate one shipping label for it
 *   to be placed in the shipping box.
 *
 **/
@RunWith(SpringRunner.class)
@SpringBootTest
public class FirstUseCaseTests {

    private Logger log = LoggerFactory.getLogger(FirstUseCaseTests.class);

    private Order order;

    @Before
    public void execute() throws Exception {
        log.info("\nStarting the first use case...");
        Address address = createAddress();
        Customer customer = createCustomer();
        order = orderService.createOrder(customer, address);
        List<Product> physicalProducts = productService.findByType(ProductType.PHYSICAL);
        orderService.addProduct(order,physicalProducts.get(0),1);

        PaymentMethod paymentMethod = paymentMethodService.createPaymentMethod("4567", PaymentMethodType.CREDIT_CARD);
        paymentService.createPayment(order, paymentMethod, orderService.totalAmount(order));
    }

    @Test
    public void testShippingLabelIsCreated() {
        List<ShippingLabel> shippingLabels = shippingLabelService.findByOrder(order);
        shippingLabels.stream().forEach(shippingLabel -> log.info(shippingLabel.toString()));
        assertTrue(shippingLabels.size()==1);
    }

    @After
    public void end() {
        log.info("\nThe first use case has finished.");
    }

    private Customer createCustomer() {
        return customerService.createCustomer("Miguel","Company","migcom@mail.com");
    }

    private Address createAddress() {
        return addressService.createAddress("Avenida Aragón",100, "Valencia","Spain","46022");
    }

    private List<Product> findProducts() {
        return productService.findByOrderAndType(order, ProductType.PHYSICAL);
        // In 'data.sql' has been inserted one PHYSICAL type product
    }

    @Autowired
    private PaymentMethodService paymentMethodService;

    @Autowired
    private OrderItemService orderItemService;

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
