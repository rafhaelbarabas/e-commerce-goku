package com.ecommerce.goku.ecommercegoku.services.places.city;

import com.ecommerce.goku.ecommercegoku.feignclients.CityFeignClient;
import com.ecommerce.goku.ecommercegoku.feignclients.dto.ibge.CityIbgeDto;
import com.ecommerce.goku.ecommercegoku.models.places.City;
import com.ecommerce.goku.ecommercegoku.models.places.State;
import com.ecommerce.goku.ecommercegoku.querybuilder.BasicQueryBuilder;
import com.ecommerce.goku.ecommercegoku.repositories.CityRepository;
import com.ecommerce.goku.ecommercegoku.services.places.state.StatesService;
import com.fasterxml.jackson.databind.ObjectMapper;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;

import static com.ecommerce.goku.ecommercegoku.models.places.QCity.city;

@Service
public class CityServiceImp implements CityService {

    private final CityRepository repository;
    private final CityFeignClient feignClient;
    private final ObjectMapper mapper;
    private final StatesService statesService;

    public CityServiceImp(CityRepository repository, CityFeignClient feignClient, ObjectMapper mapper, StatesService statesService) {
        this.repository = repository;
        this.feignClient = feignClient;
        this.mapper = mapper;
        this.statesService = statesService;
    }

    @Override
    public List<City> findByStateCode(String stateCode) {
        List<City> cities = BasicQueryBuilder.query()
                .select(city)
                .from(city)
                .where(city.state.code.eq(stateCode))
                .fetch();
        if (cities.isEmpty()) {
            List<City> citiesSave = new ArrayList<>();
            List<Object> citiesByState = feignClient.findCitiesByState(stateCode);

            citiesByState.forEach(c -> {
                State state = statesService.findByCode(stateCode);
                CityIbgeDto dto = mapper.convertValue(c, CityIbgeDto.class);

                City city = new City.Builder()
                        .id(dto.getId())
                        .name(dto.getNome())
                        .state(state)
                        .build();
                citiesSave.add(city);
            });
            repository.saveAll(citiesSave);
            return findByStateCode(stateCode);
        }
        return cities;
    }

    @Override
    public City save(City city) {
        return repository.save(city);
    }
}
