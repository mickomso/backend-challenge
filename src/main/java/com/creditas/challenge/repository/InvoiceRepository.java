package com.creditas.challenge.repository;

import com.creditas.challenge.model.Invoice;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface InvoiceRepository extends JpaRepository<Invoice, Long>, CustomInvoiceRepository {
}
