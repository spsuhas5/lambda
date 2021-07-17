package com.example.springbootlambda.lambda;

import com.amazonaws.services.lambda.runtime.Context;
import com.amazonaws.services.lambda.runtime.RequestHandler;
import com.example.springbootlambda.model.Order;
import com.example.springbootlambda.repository.OrderRepository;
import com.example.springbootlambda.service.OrderService;
import lombok.NoArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Bean;
import org.springframework.stereotype.Component;

import java.util.List;
import java.util.function.Function;
import java.util.function.Supplier;
import java.util.stream.Collectors;

@NoArgsConstructor
//@Slf4j
//@Component
public class OrderHandler implements RequestHandler<String, Object> {

    private String input;
    @Override
    public Object handleRequest(String input, Context context) {
        this.input = input;
//        log.info("input: "+input);
        return "Welcome to AWS Lambda Function Hello world";
    }

    private OrderService orderService;

    @Autowired
    public OrderHandler(OrderRepository orderRepository) {
        this.orderService = orderService;
    }

    @Bean
    public Supplier<List<Order>> orders() {
        return () -> orderService.orders().get();
    }

    @Bean
    public Function<String, List<Order>> findOrderByName() {
//        log.info("findOrderByName input: "+input);
        return (input) -> orderService
                .orders().get()
                .stream()
                .filter(order -> order.getName().equals(this.input))
                .collect(Collectors.toList());
    }

    @Bean
    public String testString() {
        return "Hello World Lambda API";
    }

    @Bean
    public List<String> testListString() {
        return List.of("Hello World Lambda API testListString()");
    }
}