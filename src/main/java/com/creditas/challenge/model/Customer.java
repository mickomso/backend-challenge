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
public class Customer {

    @Id
    @GeneratedValue(generator="seq_customer_generator")
    @SequenceGenerator(name="seq_customer_generator",sequenceName="SEQ_CUSTOMER", allocationSize=1)
    @Column(name = "CUSTOMER_ID")
    public Long id;
}
