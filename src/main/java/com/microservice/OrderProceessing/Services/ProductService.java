package com.microservice.OrderProceessing.Services;
import com.microservice.OrderProceessing.Entities.Product;
import java.util.*;

public interface ProductService {
    Product create(Product product);
    List<Product> getAll();
    Product getById(Long id);
    Product update(Long id, Product product);
    void delete(Long id);
}

