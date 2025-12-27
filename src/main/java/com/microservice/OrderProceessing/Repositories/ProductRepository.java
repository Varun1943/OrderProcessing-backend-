package com.microservice.OrderProceessing.Repositories;
import com.microservice.OrderProceessing.Entities.Product;

import org.springframework.data.jpa.repository.JpaRepository;

public interface ProductRepository extends JpaRepository<Product, Long> {
}
