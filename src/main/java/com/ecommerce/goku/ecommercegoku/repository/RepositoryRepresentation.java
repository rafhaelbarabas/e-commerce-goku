package com.ecommerce.goku.ecommercegoku.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface RepositoryRepresentation<T, ID> extends JpaRepository<T, ID> {
}
