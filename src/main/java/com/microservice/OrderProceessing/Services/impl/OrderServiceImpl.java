package com.microservice.OrderProceessing.Services.impl;

import com.microservice.OrderProceessing.Entities.Order;
import com.microservice.OrderProceessing.Entities.Product;
import com.microservice.OrderProceessing.Repositories.OrderRepository;
import com.microservice.OrderProceessing.Repositories.ProductRepository;
import com.microservice.OrderProceessing.Services.OrderService;
import jakarta.transaction.*;
import org.springframework.stereotype.Service;

@Service
public class OrderServiceImpl implements OrderService {

    private final OrderRepository orderRepo;
    private final ProductRepository productRepo;

    public OrderServiceImpl(OrderRepository orderRepo, ProductRepository productRepo) {
        this.orderRepo = orderRepo;
        this.productRepo = productRepo;
    }

    @Override
    @Transactional
    public Order placeOrder(Order order) {
        Product product = productRepo.findById(order.getProductId())
                .orElseThrow(() ->new RuntimeException("Product not found"));

        if (product.getStock() < order.getQuantity()) {
            order.setStatus("FAILED");
            return orderRepo.save(order);
        }

        // reduce inventory
        product.setStock(product.getStock() - order.getQuantity());
        productRepo.save(product);

        order.setStatus("PLACED");
        return orderRepo.save(order);
    }

    @Override
    public Order getById(Long id) {
        return orderRepo.findById(id).orElseThrow(() -> new RuntimeException("Order not found"));
    }
}
