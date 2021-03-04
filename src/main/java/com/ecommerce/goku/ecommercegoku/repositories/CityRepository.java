package com.ecommerce.goku.ecommercegoku.repositories;

import com.ecommerce.goku.ecommercegoku.models.places.City;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.repository.PagingAndSortingRepository;

public interface CityRepository extends JpaRepository<City, Long> {
}
