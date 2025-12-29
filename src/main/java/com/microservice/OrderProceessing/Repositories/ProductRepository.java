package com.microservice.OrderProceessing.Repositories;
import com.microservice.OrderProceessing.Entities.Product;

import org.springframework.data.jpa.repository.JpaRepository;
import java.util.Optional;

public interface ProductRepository extends JpaRepository<Product, Long> {
    Optional<Product> findByNameIgnoreCase(String name);
}
