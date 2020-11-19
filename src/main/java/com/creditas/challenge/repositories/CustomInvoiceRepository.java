package com.creditas.challenge.repositories;

import com.creditas.challenge.model.Invoice;
import com.creditas.challenge.model.Order;
import org.springframework.data.jpa.repository.Query;

import java.util.Optional;

public interface CustomInvoiceRepository {

    @Query("SELECT inv FROM Invoice inv WHERE inv.order = :order")
    public Optional<Invoice> findByOrder(Order order);
}
