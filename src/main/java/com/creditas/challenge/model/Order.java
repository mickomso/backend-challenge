package com.creditas.challenge.model;

import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import lombok.ToString;

import javax.persistence.*;
import java.util.Date;
import java.util.LinkedList;
import java.util.List;
import java.util.Objects;

@Getter
@Setter
@NoArgsConstructor
@Entity
@Table(name="ORDR")
public class Order {

    @Id
    @GeneratedValue(generator="seq_ordr_generator")
    @SequenceGenerator(name="seq_ordr_generator",sequenceName="SEQ_ORDR", allocationSize=1)
    @Column(name = "ORDR_ID")
    private Long id;
    @ManyToOne
    @JoinColumn(name = "CUSTOMER_ID")
    private Customer customer;
    @ManyToOne
    @JoinColumn(name = "ADDRESS_ID")
    private Address address;
    @Column(name = "CLOSED_AT")
    private Date closedAt;
    @OneToMany(fetch = FetchType.EAGER, mappedBy = "order", cascade = CascadeType.ALL, orphanRemoval = true)
    private List<OrderItem> items = new LinkedList<>();

    public Order(Customer customer, Address address) {
        this.customer = customer;
        this.address = address;
        this.closedAt = null;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        Order order = (Order) o;
        return Objects.equals(customer, order.customer) &&
                Objects.equals(address, order.address) &&
                Objects.equals(closedAt, order.closedAt) &&
                Objects.equals(items, order.items);
    }

    @Override
    public int hashCode() {
        return Objects.hash(customer, address, closedAt, items);
    }

    @Override
    public String toString() {
        return "Order{" +
                "id=" + id +
                ", customer=" + customer +
                ", address=" + address +
                ", closedAt=" + closedAt +
                '}';
    }
}
