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
@Inheritance(strategy=InheritanceType.SINGLE_TABLE)
@DiscriminatorColumn(name="DISCRIMINATOR", discriminatorType=DiscriminatorType.STRING)
@DiscriminatorValue("PAYMENT_METHOD")
public abstract class PaymentMethod {

    @Id
    @GeneratedValue(generator="seq_method_generator")
    @SequenceGenerator(name="seq_method_generator",sequenceName="SEQ_METHOD", allocationSize=1)
    @Column(name = "PAYMENT_METHOD_ID")
    private Long id;
}
