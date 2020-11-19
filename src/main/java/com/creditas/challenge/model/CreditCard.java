package com.creditas.challenge.model;

import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import lombok.ToString;

import javax.persistence.*;
import java.util.Objects;

@Getter
@Setter
@NoArgsConstructor
@ToString
@Entity
@DiscriminatorValue("CREDIT_CARD")
public class CreditCard extends PaymentMethod {

    @Column(name = "NUMBER", unique = true)
    private String number;

    @Column(name = "TYPE")
    @Enumerated(EnumType.STRING)
    private PaymentMethodType type;

    public CreditCard(String number) {
        this.number = number;
        this.type = PaymentMethodType.CREDIT_CARD;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        CreditCard that = (CreditCard) o;
        return number.equals(that.number) &&
                type == that.type;
    }

    @Override
    public int hashCode() {
        return Objects.hash(number, type);
    }
}
