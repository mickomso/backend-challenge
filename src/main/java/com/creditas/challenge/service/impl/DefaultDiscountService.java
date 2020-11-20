package com.creditas.challenge.service.impl;

import com.creditas.challenge.model.Customer;
import com.creditas.challenge.model.Discount;
import com.creditas.challenge.model.Order;
import com.creditas.challenge.repository.DiscountRepository;
import com.creditas.challenge.service.interfaces.DiscountService;
import com.creditas.challenge.service.interfaces.CustomerService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class DefaultDiscountService implements DiscountService {

    @Override
    public void createDiscount(Customer customer, Double discount) throws Exception {
        Discount savedDiscount = discountRepository.save(new Discount(customer, discount));
        if (savedDiscount != null) {
            customerService.sendEmail(customer,
                    "Congratulations!",
                    "You have just obtained a discount voucher of " + discount.toString() + ". Congratulations!");
        } else {
            throw new Exception("It has not been possible to create the purchase discount for the customer ID: " + customer.getId());
        }
    }

    @Override
    public List<Discount> findByOrderAndCustomer(Order order) {
        return discountRepository.findByCustomer(order.getCustomer());
    }

    @Autowired
    private DiscountRepository discountRepository;

    @Autowired
    private CustomerService customerService;
}
