package com.example.springbootlambda.service;

import com.example.springbootlambda.model.Order;
import com.example.springbootlambda.repository.OrderRepository;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Bean;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.function.Function;
import java.util.function.Supplier;
import java.util.stream.Collectors;

@Service
@Slf4j
public class OrderService {

    private OrderRepository orderRepository;

    @Autowired
    public OrderService(OrderRepository orderRepository) {
        this.orderRepository = orderRepository;
    }

    @Bean
    public Supplier<List<Order>> orders() {
        log.info("OrderService.orders()");
        return () -> orderRepository.buildOrders();
    }

    @Bean
    public Function<String, List<Order>> findOrderByName() {
        return (input) -> orderRepository
                .buildOrders()
                .stream()
                .filter(order -> order.getName().equals(input))
                .collect(Collectors.toList());
    }
}
