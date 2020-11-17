package com.creditas.challenge.model;

import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import lombok.ToString;

import javax.persistence.*;
import java.util.Objects;

@Getter
@Setter
@NoArgsConstructor
@ToString
@Entity
public class Invoice {

    @Id
    @GeneratedValue
    @Column(name = "INVOICE_ID")
    private Long id;
    @OneToOne(mappedBy="invoice")
    private Payment payment;
    @ManyToOne
    @JoinColumn(name = "ADDRESS_ID", insertable = false, updatable = false)
    private Address billingAddress;
    @ManyToOne
    @JoinColumn(name = "ADDRESS_ID", insertable = false, updatable = false)
    private Address shippingAddress;

    public Invoice(Payment payment) {
        this.payment = payment;
        this.billingAddress = payment.getOrder().getAddress();
        this.shippingAddress = payment.getOrder().getAddress();
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        Invoice invoice = (Invoice) o;
        return Objects.equals(payment, invoice.payment) &&
                Objects.equals(billingAddress, invoice.billingAddress) &&
                Objects.equals(shippingAddress, invoice.shippingAddress);
    }

    @Override
    public int hashCode() {
        return Objects.hash(payment, billingAddress, shippingAddress);
    }
}
