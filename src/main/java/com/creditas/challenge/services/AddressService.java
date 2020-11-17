package com.creditas.challenge.services;

import com.creditas.challenge.model.Address;

import java.util.Optional;

public interface AddressService {

    public Address saveAddress(Address address);

    public Optional<Address> findById(Long id);
}
