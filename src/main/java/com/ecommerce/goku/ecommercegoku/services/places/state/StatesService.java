package com.ecommerce.goku.ecommercegoku.services.places.state;

import com.ecommerce.goku.ecommercegoku.models.places.State;

import java.util.List;

public interface StatesService {
    State findByCode(String code);

    List<State> findAll();

}
