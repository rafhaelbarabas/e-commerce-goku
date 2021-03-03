package com.ecommerce.goku.ecommercegoku.repositories;

import com.ecommerce.goku.ecommercegoku.models.places.Address;
import org.springframework.data.jpa.repository.JpaRepository;

public interface AddressRepository extends JpaRepository<Address, Long> {
}
