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
    @GeneratedValue(generator="seq_invoice_generator")
    @SequenceGenerator(name="seq_invoice_generator",sequenceName="SEQ_INVOICE", allocationSize=1)
    @Column(name = "INVOICE_ID")
    private Long id;
    @OneToOne
    @JoinColumn(name = "ORDR_ID")
    private Order order;
    @ManyToOne
    @JoinColumn(name = "ADDRESS_ID", insertable = false, updatable = false)
    private Address billingAddress;
    @ManyToOne
    @JoinColumn(name = "ADDRESS_ID", insertable = false, updatable = false)
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
