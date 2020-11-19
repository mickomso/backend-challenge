package com.creditas.challenge.model;

import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import lombok.ToString;

import javax.persistence.*;
import javax.validation.constraints.Size;
import java.util.Objects;

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

    @Column(name = "STREET_NAME")
    private String streetName;

    @Column(name = "NUMBER")
    private int number;

    @Column(name = "CITY")
    private String city;

    @Column(name = "COUNTRY")
    private String country;

    @Column(name = "ZIP_CODE")
    private String zipCode;

    public Address(String streetName, int number, String city, String country, String zipCode) {
        this.streetName = streetName;
        this.number = number;
        this.city = city;
        this.country = country;
        this.zipCode = zipCode;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        Address address = (Address) o;
        return number == address.number &&
                id.equals(address.id) &&
                streetName.equals(address.streetName) &&
                city.equals(address.city) &&
                country.equals(address.country) &&
                zipCode.equals(address.zipCode);
    }

    @Override
    public int hashCode() {
        return Objects.hash(id, streetName, number, city, country, zipCode);
    }
}
