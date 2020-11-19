package com.creditas.challenge.services;

import com.creditas.challenge.model.Invoice;
import com.creditas.challenge.model.Order;
import com.creditas.challenge.repositories.InvoiceRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class DefaultInvoiceService implements InvoiceService {

    @Override
    public Invoice createInvoice(Order order) {
        return invoiceRepository.save(new Invoice(order));
    }

    @Autowired
    private InvoiceRepository invoiceRepository;
}
