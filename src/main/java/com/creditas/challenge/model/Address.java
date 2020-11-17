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
    @GeneratedValue
    @Column(name = "ADDRESS_ID")
    private Long id;

}
