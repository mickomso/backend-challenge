package com.creditas.challenge.model;

import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import lombok.ToString;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import java.util.Objects;

@Getter
@Setter
@NoArgsConstructor
@ToString
@Entity
public class Product {

    @Id
    @GeneratedValue
    @Column(name = "PRODUCT_ID")
    private Long id;
    @Column(name = "NAME")
    private String name;
    @Column(name = "TYPE")
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
