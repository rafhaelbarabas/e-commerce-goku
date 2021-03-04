package com.ecommerce.goku.ecommercegoku.querybuilder;

import com.ecommerce.goku.ecommercegoku.models.places.Address;
import com.querydsl.jpa.impl.JPAQuery;
import org.springframework.stereotype.Component;

import javax.persistence.EntityManager;

@Component
public class BasicQueryBuilder {

    private static EntityManager em;

    public BasicQueryBuilder(EntityManager em) {
        this.em = em;
    }

    public static JPAQuery<Address> query() {
        return new JPAQuery<>(em);
    }
}
