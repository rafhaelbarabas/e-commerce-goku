package com.ecommerce.goku.ecommercegoku.api;

import com.ecommerce.goku.ecommercegoku.models.places.Address;
import com.ecommerce.goku.ecommercegoku.services.AddressServiceRepresentation;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/api/adresses")
public class AdressesController {

    @Autowired
    AddressServiceRepresentation service;

    @PostMapping
    public ResponseEntity save(@RequestBody Address address) {
        return ResponseEntity
                .status(HttpStatus.CREATED)
                .body(service.save(address));
    }

    @PutMapping
    public ResponseEntity update(@RequestBody Address address) {
        return ResponseEntity
                .status(HttpStatus.ACCEPTED)
                .body(service.update(address));
    }

    @DeleteMapping("{id}")
    public ResponseEntity delete(@PathVariable Long id) {
        service.delete(id);
        return ResponseEntity.status(HttpStatus.NO_CONTENT).build();
    }

    @GetMapping
    public ResponseEntity findAll() {
        return ResponseEntity
                .ok()
                .body(service.findAll());
    }

    @GetMapping("{id}")
    public Address findById(@PathVariable Long id) {
        return service.findById(id);
    }
}
