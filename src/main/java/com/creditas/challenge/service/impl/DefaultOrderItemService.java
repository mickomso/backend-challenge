package com.creditas.challenge.service.impl;

import com.creditas.challenge.model.Order;
import com.creditas.challenge.model.OrderItem;
import com.creditas.challenge.repository.OrderItemRepository;
import com.creditas.challenge.service.interfaces.OrderItemService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import java.util.List;

@Service
public class DefaultOrderItemService implements OrderItemService {

    @Override
    public double total(OrderItem orderItem) {
        return orderItem.getProduct().getPrice() * orderItem.getQuantity();
    }

    @Override
    public OrderItem saveOrderItem(OrderItem orderItem) {
        return orderItemRepository.save(orderItem);
    }

    @Override
    public void deleteOrderItemsByOrder(Order order) {
        List<OrderItem> items = orderItemRepository.findByOrder(order);
        items.stream().forEach(item -> orderItemRepository.delete(item));
    }

    @Override
    public List<OrderItem> findAllByOrder(Order order) {
        return orderItemRepository.findByOrder(order);
    }

    @Autowired
    private OrderItemRepository orderItemRepository;

}
