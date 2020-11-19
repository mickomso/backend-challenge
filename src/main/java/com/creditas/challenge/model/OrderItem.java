package com.creditas.challenge.model;

import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import lombok.ToString;

import javax.persistence.*;

@Getter
@Setter
@NoArgsConstructor
@ToString
@Entity
public class OrderItem {

    @Id
    @GeneratedValue(generator="seq_orderitem_generator")
    @SequenceGenerator(name="seq_orderitem_generator",sequenceName="SEQ_ORDERITEM", allocationSize=1)
    @Column(name = "id", insertable = false, updatable = false)
    private Long id;
    @ManyToOne()
    @JoinColumn(name = "ORDR_ID")
    private Order order;
    @ManyToOne
    @JoinColumn(name = "PRODUCT_ID")
    private Product product;
    @Column(name = "QUANTITY")
    private int quantity;

    public OrderItem(Product product, int quantity) {
        this.product = product;
        this.quantity = quantity;
    }
}
