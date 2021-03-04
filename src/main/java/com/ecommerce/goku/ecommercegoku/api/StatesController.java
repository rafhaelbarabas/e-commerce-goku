package com.ecommerce.goku.ecommercegoku.api;

import com.ecommerce.goku.ecommercegoku.models.places.State;
import com.ecommerce.goku.ecommercegoku.services.places.state.StatesService;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import static java.util.Objects.nonNull;

@RestController
@RequestMapping("/api/states")
public class StatesController {

    private final StatesService service;

    public StatesController(StatesService service) {
        this.service = service;
    }

    @GetMapping("{code}")
    public ResponseEntity findByCode(@PathVariable String code) {
        State state = service.findByCode(code);
        if (nonNull(state)) {
            return ResponseEntity
                    .ok()
                    .body(state);
        } else {
            return ResponseEntity
                    .status(HttpStatus.NOT_FOUND)
                    .build();
        }
    }

    @GetMapping
    public ResponseEntity findStates() {
        return ResponseEntity
                .ok()
                .body(service.findAll());
    }

}
