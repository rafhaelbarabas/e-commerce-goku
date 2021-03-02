package com.ecommerce.goku.ecommercegoku.models.places;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;

@Entity
public class State {

    @Id
    private Long id;

    @Column(length = 100, nullable = false)
    private String name;

    @Column(length = 2, nullable = false)
    private String code;

    public State() {
    }

    public State(Long id, String name, String code) {
        this.id = id;
        this.name = name;
        this.code = code;
    }

    public Long getId() {
        return id;
    }

    public String getName() {
        return name;
    }

    public String getCode() {
        return code;
    }

    public static class Builder {
        private Long id;
        private String name;
        private String code;

        public Builder id(Long id){
            this.id = id;
            return this;
        }

        public Builder name(String name){
            this.name = name;
            return this;
        }

        public Builder code(String code){
            this.code = code;
            return this;
        }

        public State build() {
            return new State(id, name, code);
        }
    }
}
