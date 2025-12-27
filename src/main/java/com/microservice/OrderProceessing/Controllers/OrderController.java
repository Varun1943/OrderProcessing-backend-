package com.microservice.OrderProceessing.Controllers;

import com.microservice.OrderProceessing.Entities.Order;
import com.microservice.OrderProceessing.Services.OrderService;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/orders")
public class OrderController {

    private final OrderService service;

    public OrderController(OrderService service) {
        this.service = service;
    }

    @PostMapping
    public Order create(@RequestBody Order order) {
        return service.placeOrder(order);
    }

    @GetMapping("/{id}")
    public Order getById(@PathVariable Long id) {
        return service.getById(id);
    }
}
