package com.creditas.challenge;

import com.creditas.challenge.model.*;
import com.creditas.challenge.service.interfaces.AddressService;
import com.creditas.challenge.service.interfaces.CustomerService;
import com.creditas.challenge.service.interfaces.OrderService;
import com.creditas.challenge.service.interfaces.ShippingLabelService;
import org.junit.After;
import org.junit.Before;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringRunner;

import java.util.Optional;

import static org.junit.Assert.*;

@RunWith(SpringRunner.class)
@SpringBootTest
public class ShippingLabelTests {

    private Order newOrder;
    private Product newProduct;

    @Before
    public void init() {
        Optional<Customer> customer = customerService.findById(new Long(1L));
        Optional<Address> address = addressService.findById(new Long(1L));
        Order order = new Order();
        order.setAddress(address.get());
        order.setCustomer(customer.get());
        newOrder = orderService.saveOrder(order);

        newProduct = new Product("Product 6", ProductType.PHYSICAL, 10.0);
        orderService.addProduct(newOrder, newProduct, 1);
    }

    @Test
    public void testCreateShippingLabel() {
        ShippingLabel shippingLabel = shippingLabelService.createShippingLabel(newOrder, newProduct,false);
        assertNotNull("The shipping label has not been created correctly.",shippingLabel.getId());
    }

    @Test
    public void testDeleteShippingLabelByOrder() {
        ShippingLabel shippingLabel = shippingLabelService.createShippingLabel(newOrder, newProduct,false);
        Long id = shippingLabel.getId();
        shippingLabelService.deleteByOrder(newOrder);
        assertFalse("The shipping label has not been removed correctly,", shippingLabelService.findById(id).isPresent());
    }

    @After
    public void end() {
        shippingLabelService.deleteByOrder(newOrder);
        orderService.deleteOrderCompletely(newOrder);
    }

    @Autowired
    private ShippingLabelService shippingLabelService;

    @Autowired
    private CustomerService customerService;

    @Autowired
    private AddressService addressService;

    @Autowired
    private OrderService orderService;
}
