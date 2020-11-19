package com.creditas.challenge.services;

import com.creditas.challenge.model.Invoice;
import com.creditas.challenge.model.Order;

public interface InvoiceService {

    public Invoice createInvoice(Order order);
}
