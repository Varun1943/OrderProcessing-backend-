package com.microservice.OrderProceessing.Services.impl;
// import com.microservice.OrderProceessing.Entities.Product;

import com.microservice.OrderProceessing.Entities.Product;
import com.microservice.OrderProceessing.Repositories.ProductRepository;
import com.microservice.OrderProceessing.Services.ProductService;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class ProductServiceImpl implements ProductService {

    private final ProductRepository repo;

    public ProductServiceImpl(ProductRepository repo) {
    this.repo = repo;
    }
    @Override
    public Product create(Product p) {
        
        Optional<Product> existing = repo.findByNameIgnoreCase(p.getName());

        if (existing.isPresent()) {
            Product prod = existing.get();
            prod.setStock(prod.getStock() + p.getStock());  
            prod.setPrice(p.getPrice());                    
            return repo.save(prod);
        }

        return repo.save(p);
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
