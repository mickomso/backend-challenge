package com.creditas.challenge;

import com.creditas.challenge.model.*;
import com.creditas.challenge.services.AddressService;
import com.creditas.challenge.services.CustomerService;
import com.creditas.challenge.services.OrderService;
import org.junit.After;
import org.junit.Before;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringRunner;

import java.util.Optional;

import static org.junit.Assert.assertEquals;
import static org.junit.jupiter.api.Assertions.assertTrue;

@RunWith(SpringRunner.class)
@SpringBootTest
public class OrderTests {

    private Order newOrder;

    @Before
    public void init() {
        Optional<Customer> customer = customerService.findById(new Long(1L));
        Optional<Address> address = addressService.findById(new Long(1L));
        Order order = new Order();
        order.setAddress(address.get());
        order.setCustomer(customer.get());
        newOrder = orderService.saveOrder(order);
    }

    @Test
    public void testEmptyProductListWhenNoProductAdded() {
        assertTrue(newOrder.getItems().isEmpty(), () -> "List of items should be empty.");
    }

    @Test
    public void testTotalAmount() {
        orderService.addProduct(newOrder,new Product("Product 1", ProductType.DIGITAL, 10.0), 2);
        orderService.addProduct(newOrder,new Product("Product 2", ProductType.DIGITAL, 15.0), 2);
        double total = orderService.totalAmount(newOrder);

        assertEquals(total, 50.0, 0.0);
    }

    @Test
    public void testAddProduct() {
        orderService.addProduct(newOrder,new Product("Product 3", ProductType.MEMBERSHIP, 10.0), 1);
        orderService.addProduct(newOrder,new Product("Product 4", ProductType.PHYSICAL, 11.0), 1);
        orderService.addProduct(newOrder,new Product("Product 5", ProductType.BOOK, 12.0), 1);
        assertEquals(newOrder.getItems().size(), 3);
    }

    @After
    public void end() {
        orderService.deleteOrderCompletely(newOrder);
    }

    @Autowired
    private CustomerService customerService;

    @Autowired
    private AddressService addressService;

    @Autowired
    private OrderService orderService;
}
