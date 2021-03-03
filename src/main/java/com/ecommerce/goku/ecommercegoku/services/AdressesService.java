package com.ecommerce.goku.ecommercegoku.services;

import com.ecommerce.goku.ecommercegoku.models.places.Address;
import com.ecommerce.goku.ecommercegoku.repository.BasicRepository;
import com.querydsl.jpa.impl.JPAQuery;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class AdressesService implements AddressServiceRepresentation {

    private final BasicRepository repository;

    public AdressesService(BasicRepository repository) {
        this.repository = repository;
    }

    @Override
    public Address save(Address address) {
        return (Address) repository.save(address);
    }

    @Override
    public Address update(Address address) {
        return null;
    }

    @Override
    public Address findById(Long id) {

//        JPAQuery<?> query = new JPAQuery<Void>(em);
//
//        return query.select(address)
//                .from(address)
//                .where(address.id.eq(id))
//                .fetchOne();
        return null;
    }

    @Override
    public List<Address> findByZipCode(String zipCode) {
        return null;
    }

    @Override
    public List<Address> findAll() {
        return null;
    }

    @Override
    public void delete(Long id) {

    }
}
