package com.ecommerce.goku.ecommercegoku.feignclients;

import org.springframework.cloud.openfeign.FeignClient;
import org.springframework.stereotype.Component;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;

import java.util.List;

@Component
@FeignClient(name = "cities-ibge", url = "https://servicodados.ibge.gov.br/api/v1/localidades/estados")
public interface CityFeignClient {

    @GetMapping("{state}/municipios")
    public List<Object> findCitiesByState(@PathVariable String state);
}
