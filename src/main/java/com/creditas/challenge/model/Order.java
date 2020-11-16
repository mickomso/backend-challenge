package com.creditas.challenge.model;

import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import java.util.Date;
import java.util.LinkedList;
import java.util.List;
import java.util.Objects;

@Getter
@Setter
@NoArgsConstructor
public class Order {

    private Customer customer;
    private Address address;
    private Date closedAt;
    private Payment payment;

    private List<OrderItem> items = new LinkedList<>();

    public Order(Customer customer, Address address) {
        this.customer = customer;
        this.address = address;
        this.closedAt = null;
        this.payment = null;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        Order order = (Order) o;
        return Objects.equals(customer, order.customer) &&
                Objects.equals(address, order.address) &&
                Objects.equals(closedAt, order.closedAt) &&
                Objects.equals(payment, order.payment) &&
                Objects.equals(items, order.items);
    }

    @Override
    public int hashCode() {
        return Objects.hash(customer, address, closedAt, payment, items);
    }
}
