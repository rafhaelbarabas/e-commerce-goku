package com.ecommerce.goku.ecommercegoku.api;

import com.ecommerce.goku.ecommercegoku.models.places.City;
import com.ecommerce.goku.ecommercegoku.models.places.State;
import com.ecommerce.goku.ecommercegoku.services.places.city.CityService;
import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.databind.ObjectMapper;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.domain.Sort;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.ArrayList;
import java.util.List;

@RestController
@RequestMapping(value = "/api/cities")
public class CitiesController {

    private final CityService service;

    public CitiesController(CityService service) {
        this.service = service;
    }

    @GetMapping("{code}")
    public ResponseEntity findByStateCode(@PathVariable String code) {
        List<City> cities = service.findByStateCode(code);

        if (!cities.isEmpty()) {
            return ResponseEntity
                    .ok()
                    .body(cities);
        } else {
            return ResponseEntity
                    .status(HttpStatus.NOT_FOUND)
                    .build();
        }
    }
}
