package com.ecommerce.goku.ecommercegoku.models.places;

import javax.persistence.*;

@Entity
public class Address {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @Column
    private String address;

    @Column
    private String zipCode;

    @OneToMany
    private City city;

    public Address() {
    }

    public Address(String address, String zipCode, City city) {
        this.address = address;
        this.zipCode = zipCode;
        this.city = city;
    }

    public Long getId() {
        return id;
    }

    public String getAddress() {
        return address;
    }

    public String getZipCode() {
        return zipCode;
    }

    public City getCity() {
        return city;
    }

    public static class Builder {

        private String address;
        private String zipCode;
        private City city;

        public Builder address(String address) {
            this.address = address;
            return this;
        }

        public Builder zipCode(String zipCode) {
            this.zipCode = zipCode;
            return this;
        }

        public Builder city(City city) {
            this.city = city;
            return this;
        }

        public Address build() {
            return new Address(address, zipCode, city);
        }
    }
}
