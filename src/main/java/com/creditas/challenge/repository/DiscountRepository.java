package com.creditas.challenge.repository;

import com.creditas.challenge.model.Customer;
import com.creditas.challenge.model.Discount;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface DiscountRepository extends JpaRepository<Discount, Long>, CustomDiscountRepository {

    public List<Discount> findByCustomer(Customer customer);
}
