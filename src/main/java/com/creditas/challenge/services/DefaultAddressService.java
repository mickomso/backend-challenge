package com.creditas.challenge.services;

import com.creditas.challenge.model.Address;
import com.creditas.challenge.repositories.AddressRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.Optional;

@Service
public class DefaultAddressService implements AddressService {

    @Override
    public Address saveAddress(Address address) {
        return addressRepository.save(address);
    }

    @Override
    public Optional<Address> findById(Long id) {
        return addressRepository.findById(id);
    }

    @Override
    public Address createAddress(String streetName, int number, String city, String country, String zipCode) {
        Address addressSaved = this.saveAddress(new Address(streetName,number,city,country,zipCode));
        return addressSaved;
    }

    @Autowired
    private AddressRepository addressRepository;

}
