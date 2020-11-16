package com.creditas.challenge.model;

import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import java.util.Date;
import java.util.Objects;

@Getter
@Setter
@NoArgsConstructor
public class Payment {

    private Order order;
    private PaymentMethod paymentMethod;
    private Date paidAt;
    private long authorizationNumber;
    private double amount;
    private Invoice invoice;

    public Payment(Order order, PaymentMethod paymentMethod) {
        this.order = order;
        this.paymentMethod = paymentMethod;
        this.paidAt = new Date();
        this.authorizationNumber = paidAt.getTime();
        //this.amount = order.totalAmount();
        this.amount = 0;
        this.invoice = new Invoice(order);
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        Payment payment = (Payment) o;
        return authorizationNumber == payment.authorizationNumber &&
                Double.compare(payment.amount, amount) == 0 &&
                Objects.equals(order, payment.order) &&
                Objects.equals(paymentMethod, payment.paymentMethod) &&
                Objects.equals(paidAt, payment.paidAt) &&
                Objects.equals(invoice, payment.invoice);
    }

    @Override
    public int hashCode() {
        return Objects.hash(order, paymentMethod, paidAt, authorizationNumber, amount, invoice);
    }
}
