package com.creditas.challenge.services;

import com.creditas.challenge.model.Invoice;
import com.creditas.challenge.model.Order;
import com.creditas.challenge.repositories.InvoiceRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.Optional;

@Service
public class DefaultInvoiceService implements InvoiceService {

    @Override
    public Invoice createInvoice(Order order) {
        return invoiceRepository.save(new Invoice(order));
    }

    @Override
    public void deleteByOrder(Order order) {
        Optional<Invoice> invoiceFound = invoiceRepository.findByOrder(order);
        if (invoiceFound.isPresent()) {
            invoiceRepository.deleteById(invoiceFound.get().getId());
        }
    }

    @Autowired
    private InvoiceRepository invoiceRepository;
}
