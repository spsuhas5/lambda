package com.example.springbootlambda.repository;

import com.example.springbootlambda.model.Order;
import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Repository;

import java.util.List;
import java.util.stream.Collectors;
import java.util.stream.Stream;

@Repository
@Slf4j
public class OrderRepository {

    public List<Order> buildOrders() {
        log.info("OrderRepository.buildOrders()");
        return Stream.of(
                new Order(101, "Mobie", 20000, 2),
                new Order(222, "Book", 500, 4),
                new Order(456, "Book", 800, 6),
                new Order(999, "Jeans", 1500, 8)
        ).collect(Collectors.toList());
    }
}
