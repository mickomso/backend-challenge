package com.creditas.challenge.model;

import lombok.NoArgsConstructor;
import lombok.ToString;

import javax.persistence.*;

@NoArgsConstructor
@ToString
@Entity
@Inheritance(strategy=InheritanceType.SINGLE_TABLE)
@DiscriminatorColumn(name="DISCRIMINATOR", discriminatorType=DiscriminatorType.STRING)
@DiscriminatorValue("PAYMENT_METHOD")
@Table(name = "PAYMENT_METHOD")
public abstract class PaymentMethod {

    @Id
    @GeneratedValue
    @Column(name = "PAYMENT_METHOD_ID")
    private Long id;
}
