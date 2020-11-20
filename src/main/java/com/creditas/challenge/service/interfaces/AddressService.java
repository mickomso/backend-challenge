package com.creditas.challenge.service.interfaces;

import com.creditas.challenge.model.Address;

import java.util.Optional;

public interface AddressService {

    /**
     * Saves an address entity
     * @param address
     * @return the address entity saved
     */
    public Address saveAddress(Address address);

    /**
     * Finds if it exists an address by its id
     * @param id
     * @return an optional object with the address found or nothing
     */
    public Optional<Address> findById(Long id);

    /**
     * Creates and saves an address entity
     * @param streetName
     * @param number
     * @param city
     * @param country
     * @param zipCode
     * @return the saved address
     */
    public Address createAddress(String streetName, int number, String city, String country, String zipCode);
}
