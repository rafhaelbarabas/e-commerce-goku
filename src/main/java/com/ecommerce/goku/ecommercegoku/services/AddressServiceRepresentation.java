package com.ecommerce.goku.ecommercegoku.services;

import com.ecommerce.goku.ecommercegoku.models.places.Address;

import java.util.List;

public interface AddressServiceRepresentation {
    public Address save(Address address);

    public Address update(Address address);

    public Address findById(Long id);

    public List<Address> findByZipCode(String zipCode);

    public List<Address> findAll();

    public void delete(Long id);
}
