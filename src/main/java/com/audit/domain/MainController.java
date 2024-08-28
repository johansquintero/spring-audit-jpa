package com.audit.domain;

import com.audit.persistence.entities.Product;
import com.audit.persistence.repositories.IProductRepository;
import lombok.AllArgsConstructor;
import org.springframework.http.ResponseEntity;
import org.springframework.security.access.prepost.PreAuthorize;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping(path = "/api/products")
@AllArgsConstructor
public class MainController {
    private final IProductRepository productRepository;

    @PreAuthorize("hasRole('USER')")
    @GetMapping
    public ResponseEntity<List<Product>> getAll() {
        return ResponseEntity.ok(this.productRepository.getAll());
    }


    @PreAuthorize("hasAnyRole('ADMIN','USER')")
    @PostMapping(path = "/create")
    public ResponseEntity<Product> addProduct(@RequestBody Product product) {
        return ResponseEntity.of(this.productRepository.save(product));
    }

    @PreAuthorize("hasRole('ADMIN')")
    @PutMapping(path = "/update")
    public ResponseEntity<Product> updateProduct(@RequestBody Product product) {
        return ResponseEntity.of(this.productRepository.update(product));
    }

    @PreAuthorize("hasRole('ADMIN')")
    @DeleteMapping(path = "/delete/{id}")
    public ResponseEntity<String> updateProduct(@PathVariable Long id) {
        return ResponseEntity.ok(this.productRepository.delete(id));
    }
}
