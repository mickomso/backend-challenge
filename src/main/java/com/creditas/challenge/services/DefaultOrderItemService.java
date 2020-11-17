package com.creditas.challenge.services;

import com.creditas.challenge.model.Order;
import com.creditas.challenge.model.OrderItem;
import com.creditas.challenge.repositories.OrderItemRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class DefaultOrderItemService implements OrderItemService {

    @Autowired
    private OrderItemRepository orderItemRepository;

    @Override
    public double total(OrderItem orderItem) {
        return orderItem.getProduct().getPrice() * orderItem.getQuantity();
    }

    @Override
    public OrderItem saveOrderItem(OrderItem orderItem) {
        return orderItemRepository.save(orderItem);
    }
}
