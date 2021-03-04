package com.ecommerce.goku.ecommercegoku.feignclients.dto.ibge;

import com.ecommerce.goku.ecommercegoku.models.places.State;

public class CityIbgeDto {
    private Long id;
    private String nome;
    private State state;

    public CityIbgeDto() {
    }

    public CityIbgeDto(Long id, String nome, State state) {
        this.id = id;
        this.nome = nome;
        this.state = state;
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getNome() {
        return nome;
    }

    public void setNome(String nome) {
        this.nome = nome;
    }

    public State getState() {
        return state;
    }

    public void setState(State state) {
        this.state = state;
    }
}
