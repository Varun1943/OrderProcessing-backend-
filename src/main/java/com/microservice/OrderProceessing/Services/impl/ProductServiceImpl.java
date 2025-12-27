package com.microservice.OrderProceessing.Services.impl;
// import com.microservice.OrderProceessing.Entities.Product;

import com.microservice.OrderProceessing.Entities.Product;
import com.microservice.OrderProceessing.Repositories.ProductRepository;
import com.microservice.OrderProceessing.Services.ProductService;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class ProductServiceImpl implements ProductService {

    private final ProductRepository repo;

    public ProductServiceImpl(ProductRepository repo) {
    this.repo = repo;
    }
    @Override
    public Product create(Product product) {
    return repo.save(product);
    }
    @Override
    public List<Product> getAll() {
    return repo.findAll();
    }

    @Override
    public Product getById(Long id) {
    return repo.findById(id).orElseThrow(()->new RuntimeException("Product not found"));
    }

    @Override
    public Product update(Long id, Product product) {
        Product existing = getById(id);
        existing.setName(product.getName());
        existing.setStock(product.getStock());
        return repo.save(existing);
    }

    @Override
    public void delete(Long id) {
        repo.deleteById(id);
    }
}
