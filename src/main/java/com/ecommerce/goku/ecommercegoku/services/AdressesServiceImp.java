package com.ecommerce.goku.ecommercegoku.services;

import com.ecommerce.goku.ecommercegoku.models.places.Address;
import com.ecommerce.goku.ecommercegoku.repositories.AddressRepository;
import com.querydsl.jpa.impl.JPAQuery;
import org.springframework.http.HttpStatus;
import org.springframework.stereotype.Service;
import org.springframework.web.server.ResponseStatusException;

import javax.persistence.EntityManager;
import java.util.List;

import static com.ecommerce.goku.ecommercegoku.models.places.QAddress.address1;

@Service
public class AdressesServiceImp implements AddressService {

    private final AddressRepository repository;
    private final EntityManager em;

    public AdressesServiceImp(AddressRepository repository, EntityManager em) {
        this.repository = repository;
        this.em = em;
    }

    private JPAQuery<Address> query() {
        return new JPAQuery<>(em);
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
        return query().select(address1)
                .from(address1)
                .where(address1.zipCode.like(zipCode))
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
