package com.creditas.challenge.repository;

import com.creditas.challenge.model.ShippingLabel;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface ShippingLabelRepository extends JpaRepository<ShippingLabel,Long>, CustomShippingLabelRepository {
}
