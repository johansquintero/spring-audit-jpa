package com.audit.persistence.repositories;

import com.audit.persistence.entities.Product;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.Optional;

public interface IProductCrudRepository extends JpaRepository<Product,Long> {
    Optional<Product> findProductById(Long id);
    Optional<Product> findProductByName(String name);
}
