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
public class Subscription {

    @Id
    @GeneratedValue(generator="seq_subscription_generator")
    @SequenceGenerator(name="seq_subscription_generator",sequenceName="SEQ_SUBSCRIPTION", allocationSize=1)
    @Column(name = "SUBSCRIPTION_ID")
    private Long id;
    @ManyToOne
    @JoinColumn(name = "CUSTOMER_ID")
    private Customer customer;
    @Column(name = "ACTIVE")
    private boolean active;
    @Column(name = "USER_NOTIFIED")
    private boolean userNotified;

    public Subscription(Customer customer, boolean active) {
        this.customer = customer;
        this.active = active;
        this.userNotified = false;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        Subscription that = (Subscription) o;
        return active == that.active &&
                userNotified == that.userNotified &&
                id.equals(that.id) &&
                customer.equals(that.customer);
    }

    @Override
    public int hashCode() {
        return Objects.hash(id, customer, active, userNotified);
    }

    @Override
    public String toString() {
        return "Subscription{" +
                "id=" + id +
                ", customer=" + customer +
                ", active=" + active +
                ", userNotified=" + userNotified +
                '}';
    }
}
