package com.creditas.challenge.model;

import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import lombok.ToString;

import javax.persistence.*;
import java.util.Date;
import java.util.Objects;

@Getter
@Setter
@NoArgsConstructor
@ToString
@Entity
public class Payment {

    @Id
    @GeneratedValue(generator="seq_payment_generator")
    @SequenceGenerator(name="seq_payment_generator",sequenceName="SEQ_PAYMENT", allocationSize=1)
    @Column(name = "PAYMENT_ID")
    private Long id;
    @OneToOne
    @JoinColumn(name = "ORDR_ID")
    private Order order;
    @ManyToOne
    @JoinColumn(name = "PAYMENT_METHOD_ID")
    private PaymentMethod paymentMethod;
    @Column(name = "PAID_AT")
    private Date paidAt;
    @Column(name = "AUTHORIZATION_NUMBER")
    private long authorizationNumber;
    @Column(name = "AMOUNT")
    private double amount;

    public Payment(Order order, PaymentMethod paymentMethod, Double amount) {
        this.order = order;
        this.paymentMethod = paymentMethod;
        this.paidAt = new Date();
        this.authorizationNumber = paidAt.getTime();
        this.amount = amount;
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
                Objects.equals(paidAt, payment.paidAt);
    }

    @Override
    public int hashCode() {
        return Objects.hash(order, paymentMethod, paidAt, authorizationNumber, amount);
    }
}
