package com.audit.persistence.repositories;

import com.audit.persistence.entities.Product;
import lombok.AllArgsConstructor;
import org.springframework.stereotype.Repository;

import java.util.List;
import java.util.Optional;

@Repository
@AllArgsConstructor
public class ProductRepositoryImpl implements IProductRepository {
    private final IProductCrudRepository crudRepository;

    @Override
    public List<Product> getAll() {
        return this.crudRepository.findAll();
    }

    @Override
    public Optional<Product> getById(Long id) {
        return this.crudRepository.findProductById(id);
    }

    @Override
    public Optional<Product> save(Product product) {
        Optional<Product> productOpt = this.crudRepository.findProductByName(product.getName());
        if (productOpt.isPresent()) {
            throw new RuntimeException("El producto ya existe!");
        }
        return Optional.of(this.crudRepository.save(product));
    }

    @Override
    public Optional<Product> update(Product product) {
        Optional<Product> productOpt = this.crudRepository.findProductById(product.getId());
        if (productOpt.isEmpty()) {
            throw new RuntimeException("El producto no existe!");
        }
        return Optional.of(this.crudRepository.save(product));
    }

    @Override
    public String delete(Long id) {
        if (this.crudRepository.findProductById(id).isEmpty()) {
            throw new RuntimeException("El producto no existe!");
        }
        this.crudRepository.deleteById(id);
        return "Producto eliminado con exito";
    }
}
