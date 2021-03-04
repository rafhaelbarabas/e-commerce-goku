package com.ecommerce.goku.ecommercegoku.services.places.state;

import com.ecommerce.goku.ecommercegoku.feignclients.StateFeignClient;
import com.ecommerce.goku.ecommercegoku.feignclients.dto.ibge.StateIbgeDto;
import com.ecommerce.goku.ecommercegoku.models.places.State;
import com.ecommerce.goku.ecommercegoku.querybuilder.BasicQueryBuilder;
import com.ecommerce.goku.ecommercegoku.repositories.StateRepository;
import com.fasterxml.jackson.databind.ObjectMapper;
import org.springframework.stereotype.Service;

import javax.persistence.EntityManager;
import java.util.ArrayList;
import java.util.List;

import static com.ecommerce.goku.ecommercegoku.models.places.QState.state;

@Service
public class StateServiceImp implements StatesService {

    private final StateRepository repository;
    private final EntityManager em;
    private final StateFeignClient feignClient;
    private final ObjectMapper mapper;

    public StateServiceImp(StateRepository repository, EntityManager em, StateFeignClient feignClient, ObjectMapper mapper) {
        this.repository = repository;
        this.em = em;
        this.feignClient = feignClient;
        this.mapper = mapper;
    }

    @Override
    public State findByCode(String code) {
        return BasicQueryBuilder.query()
                .select(state)
                .from(state)
                .where(state.code.eq(code))
                .fetchOne();
    }

    @Override
    public List<State> findAll() {
        List<State> states = repository.findAll();

        if (states.isEmpty()) {
            List<State> statesSave = new ArrayList<>();
            List<Object> statesIbge = feignClient.findStates();

            statesIbge.forEach(stateIbge -> {
                StateIbgeDto dto = mapper.convertValue(stateIbge, StateIbgeDto.class);

                State stateBuild = new State.Builder()
                        .id(dto.getId())
                        .name(dto.getNome())
                        .code(dto.getSigla())
                        .build();

                statesSave.add(stateBuild);
            });
            repository.saveAll(statesSave);
            return findAll();
        }
        return states;
    }
}
