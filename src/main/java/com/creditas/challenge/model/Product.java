package com.creditas.challenge.model;

import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import lombok.ToString;
import org.hibernate.annotations.NamedQueries;
import org.hibernate.annotations.NamedQuery;

import javax.persistence.*;
import java.util.Objects;

@Getter
@Setter
@NoArgsConstructor
@ToString
@Entity
@Table(name = "PRODUCT")
@NamedQueries({
        @NamedQuery(name="Product.findProductsByOrderId",
                query="SELECT p " +
                        "FROM Product p, OrderItem ordit, Order ord " +
                        "WHERE p.id = ordit.id " +
                        "AND ordit.id = ord.id " +
                        "AND ordit.id = :orderId ")
})
public class Product {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "PRODUCT_ID")
    private Long id;
    @Column(name = "NAME")
    private String name;
    @Column(name = "TYPE")
    @Enumerated(EnumType.STRING)
    private ProductType type;
    @Column(name = "PRICE")
    private double price;

    public Product(String name, ProductType type, double price) {
        this.name = name;
        this.type = type;
        this.price = price;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        Product product = (Product) o;
        return Double.compare(product.price, price) == 0 &&
                Objects.equals(name, product.name) &&
                type == product.type;
    }

    @Override
    public int hashCode() {
        return Objects.hash(name, type, price);
    }
}
