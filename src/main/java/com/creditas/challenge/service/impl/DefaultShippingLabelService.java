package com.creditas.challenge.service.impl;

import com.creditas.challenge.model.*;
import com.creditas.challenge.repository.ShippingLabelRepository;
import com.creditas.challenge.service.interfaces.ShippingLabelService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class DefaultShippingLabelService implements ShippingLabelService {

    @Override
    public ShippingLabel createShippingLabel(Order order, Product product, boolean exempt) {
        ShippingLabel shippingLabelSaved = shippingLabelRepository.save(new ShippingLabel(order,product,exempt));
        printShippingLabel(shippingLabelSaved);
        return shippingLabelSaved;
    }

    @Override
    public void printShippingLabel(ShippingLabel shippingLabel) {
        // TODO Not covered by this prototype
    }

    @Override
    public void deleteByOrder(Order order) {
        shippingLabelRepository.deleteByOrder(order);
    }

    @Override
    public Optional<ShippingLabel> findById(Long id) {
        return shippingLabelRepository.findById(id);
    }

    @Override
    public List<ShippingLabel> findByOrder(Order order) {
        return shippingLabelRepository.findByOrder(order);
    }

    @Autowired
    private ShippingLabelRepository shippingLabelRepository;
}
