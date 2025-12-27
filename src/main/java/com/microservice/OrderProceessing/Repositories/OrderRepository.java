package com.microservice.OrderProceessing.Repositories;

import com.microservice.OrderProceessing.Entities.Order;
import org.springframework.data.jpa.repository.JpaRepository;

public interface OrderRepository extends JpaRepository<Order, Long> {
}
