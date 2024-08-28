package com.audit.persistence.repositories;


import com.audit.persistence.entities.Product;

import java.util.List;
import java.util.Optional;

public interface IProductRepository {

    List<Product> getAll();

    Optional<Product> getById(Long id);

    Optional<Product> save(Product product);

    Optional<Product> update(Product product);

    String delete(Long id);

}
