package com.creditas.challenge.model;

import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import java.util.Objects;

@Getter
@Setter
@NoArgsConstructor
public class Invoice {
    private Order order;
    private Address billingAddress;
    private Address shippingAddress;

    public Invoice(Order order) {
        this.order = order;
        this.billingAddress = order.getAddress();
        this.shippingAddress = order.getAddress();
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        Invoice invoice = (Invoice) o;
        return Objects.equals(order, invoice.order) &&
                Objects.equals(billingAddress, invoice.billingAddress) &&
                Objects.equals(shippingAddress, invoice.shippingAddress);
    }

    @Override
    public int hashCode() {
        return Objects.hash(order, billingAddress, shippingAddress);
    }
}
