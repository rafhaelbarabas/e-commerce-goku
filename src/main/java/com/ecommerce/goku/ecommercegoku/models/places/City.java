package com.ecommerce.goku.ecommercegoku.models.places;

import javax.persistence.*;

@Entity
@Table(name = "cities", uniqueConstraints = {@UniqueConstraint(columnNames = {"name", "id_state"})})
public class City {

    @Id
    private Long id;

    @Column
    private String name;

    @ManyToOne
    @JoinColumn(nullable = false, name = "id_state", foreignKey = @ForeignKey(name = "fk_city_state"))
    private State state;

    public City() {
    }

    public City(Long id, String name, State state) {
        this.id = id;
        this.name = name;
        this.state = state;
    }

    public static class Builder {
        private Long id;
        private String name;
        private State state;

        public Builder id(Long id) {
            this.id = id;
            return this;
        }

        public Builder name(String name) {
            this.name = name;
            return this;
        }

        public Builder state(State state) {
            this.state = state;
            return this;
        }

        public City build() {
            return new City(id, name, state);
        }
    }
}
