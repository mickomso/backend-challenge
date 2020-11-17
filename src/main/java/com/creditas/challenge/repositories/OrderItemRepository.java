package com.creditas.challenge.repositories;

import com.creditas.challenge.model.Order;
import com.creditas.challenge.model.OrderItem;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface OrderItemRepository extends JpaRepository<OrderItem, Long> {
}
