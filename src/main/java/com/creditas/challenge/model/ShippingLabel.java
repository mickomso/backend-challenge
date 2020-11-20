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
public class ShippingLabel {

    @Id
    @GeneratedValue(generator="seq_shipping_generator")
    @SequenceGenerator(name="seq_shipping_generator",sequenceName="SEQ_SHIPPING", allocationSize=1)
    @Column(name = "SHIPPING_LABEL_ID")
    private Long id;
    @ManyToOne
    @JoinColumn(name = "ORDR_ID")
    private Order order;
    @Column(name = "CREATED_AT")
    private Date createdAt;
    @ManyToOne
    @JoinColumn(name = "PRODUCT_ID")
    private Product product;

    public ShippingLabel(Order order, Product product) {
        this.order = order;
        this.createdAt = new Date();
        this.product = product;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        ShippingLabel that = (ShippingLabel) o;
        return order.equals(that.order) &&
                product.equals(that.product);
    }

    @Override
    public int hashCode() {
        return Objects.hash(order, product);
    }
}