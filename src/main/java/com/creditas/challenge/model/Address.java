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
@Table(name = "ADDRESS")
public class Address {

    @Id
    @GeneratedValue(generator="seq_address_generator")
    @SequenceGenerator(name="seq_address_generator",sequenceName="SEQ_ADDRESS", allocationSize=1)
    @Column(name = "ADDRESS_ID")
    private Long id;

}
