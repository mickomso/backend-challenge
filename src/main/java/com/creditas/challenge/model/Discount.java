package com.creditas.challenge.model;

import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import javax.persistence.*;
import java.util.Objects;

@Getter
@Setter
@NoArgsConstructor
@Entity
public class Discount {

    @Id
    @GeneratedValue(generator="seq_discount_generator")
    @SequenceGenerator(name="seq_discount_generator",sequenceName="SEQ_DISCOUNT", allocationSize=1)
    @Column(name = "DISCOUNT_ID")
    private Long id;
    @ManyToOne
    @JoinColumn(name = "CUSTOMER_ID")
    private Customer customer;
    @Column(name = "DISCOUNT")
    private Double discount;

    public Discount(Customer customer, Double discount) {
        this.customer = customer;
        this.discount = discount;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        Discount discount1 = (Discount) o;
        return id.equals(discount1.id) &&
                customer.equals(discount1.customer) &&
                discount.equals(discount1.discount);
    }

    @Override
    public int hashCode() {
        return Objects.hash(id, customer, discount);
    }

    @Override
    public String toString() {
        return "The customer '" + customer.getFirstName() + " " + customer.getLastName() +
                "' has obtained a DISCOUNT of " + discount + "%.";
    }
}
