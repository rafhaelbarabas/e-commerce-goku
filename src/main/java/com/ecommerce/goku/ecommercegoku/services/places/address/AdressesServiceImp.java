package com.ecommerce.goku.ecommercegoku.services.places.address;

import com.ecommerce.goku.ecommercegoku.models.places.Address;
import com.ecommerce.goku.ecommercegoku.querybuilder.BasicQueryBuilder;
import com.ecommerce.goku.ecommercegoku.repositories.AddressRepository;
import org.springframework.http.HttpStatus;
import org.springframework.stereotype.Service;
import org.springframework.web.server.ResponseStatusException;

import java.util.List;

import static com.ecommerce.goku.ecommercegoku.models.places.QAddress.address1;

@Service
public class AdressesServiceImp implements AddressService {

    private final AddressRepository repository;

    public AdressesServiceImp(AddressRepository repository) {
        this.repository = repository;
    }

    @Override
    public Address save(Address address) {
        return repository.save(address);
    }

    @Override
    public Address update(Address address) {
        return repository.save(address);
    }

    @Override
    public Address findById(Long id) {
        return repository.findById(id)
                .orElseThrow(() -> new ResponseStatusException(HttpStatus.NOT_FOUND, "Address not found"));
    }

    @Override
    public List<Address> findByZipCode(String zipCode) {
        return BasicQueryBuilder.query()
                .select(address1)
                .from(address1)
                .where(address1.zipCode.contains(zipCode))
                .fetch();
    }

    @Override
    public List<Address> findAll() {
        return repository.findAll();
    }

    @Override
    public void delete(Long id) {
        Address address = findById(id);
        repository.delete(address);
    }
}
