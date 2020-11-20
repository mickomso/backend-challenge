package com.creditas.challenge.service.interfaces;

import com.creditas.challenge.model.Invoice;
import com.creditas.challenge.model.Order;

public interface InvoiceService {

    /**
     * Creates and saves an invoice entity
     * @param order
     * @return the invoice entity saved
     */
    public Invoice createInvoice(Order order);

    /**
     * Deletes an invoice by the associated order
     * @param order
     */
    public void deleteByOrder(Order order);
}
