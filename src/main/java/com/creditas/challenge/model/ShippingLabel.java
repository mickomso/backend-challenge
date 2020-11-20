package com.creditas.challenge.model;

import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import javax.persistence.*;
import java.util.Date;
import java.util.Objects;

@Getter
@Setter
@NoArgsConstructor
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
    @Column(name = "TAX_EXEMPT")
    private boolean taxExempt;

    public ShippingLabel(Order order, Product product, boolean taxExempt) {
        this.order = order;
        this.createdAt = new Date();
        this.product = product;
        this.taxExempt = taxExempt;
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
        return Objects.hash(id, order, product);
    }

    @Override
    public String toString() {
        String taxExempText = "TAX-EXEMPT ITEM";
        if (!taxExempt) {
            taxExempText = "";
        }
        return "SHIPPING LABEL {" +
                "order_id=" + order.getId() +
                ", product=Product(id=" + product.getId() +
                ", type=" + product.getType() +
                ", price=" + product.getPrice() + "  (" +
                taxExempText +
                "))" +
                ", customer=" + order.getCustomer().getFirstName() +
                " " + order.getCustomer().getLastName() +
                ", address=" + order.getAddress() +
                ", createdAt=" + createdAt +
                '}';
    }
}
