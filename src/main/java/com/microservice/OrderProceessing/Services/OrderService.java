package com.microservice.OrderProceessing.Services;

import com.microservice.OrderProceessing.Entities.Order;

public interface OrderService {
    Order placeOrder(Order order);
    Order getById(Long id);
}
