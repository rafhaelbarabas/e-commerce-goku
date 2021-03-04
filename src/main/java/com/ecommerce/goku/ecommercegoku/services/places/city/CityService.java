package com.ecommerce.goku.ecommercegoku.services.places.city;

import com.ecommerce.goku.ecommercegoku.models.places.City;

import java.util.List;

public interface CityService {
    List<City> findByStateCode(String stateCode);
}
