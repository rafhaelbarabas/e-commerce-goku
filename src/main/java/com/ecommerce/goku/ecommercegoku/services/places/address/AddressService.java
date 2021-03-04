package com.ecommerce.goku.ecommercegoku.services.places.address;

import com.ecommerce.goku.ecommercegoku.models.places.Address;

import java.util.List;

public interface AddressService {
    Address save(Address address);

    Address update(Address address);

    Address findById(Long id);

    List<Address> findByZipCode(String zipCode);

    List<Address> findAll();

    void delete(Long id);
}
