package com.ecommerce.goku.ecommercegoku.feignclients;

import org.springframework.cloud.openfeign.FeignClient;
import org.springframework.stereotype.Component;
import org.springframework.web.bind.annotation.GetMapping;

import java.util.List;

@Component
@FeignClient(name = "states-ibge", url = "https://servicodados.ibge.gov.br/api/v1/localidades", path = "/estados")
public interface StateFeignClient {

    @GetMapping
    public List<Object> findStates();
}
