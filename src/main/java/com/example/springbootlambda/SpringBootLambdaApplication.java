package com.example.springbootlambda;

import com.example.springbootlambda.model.Book;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.Bean;

import java.util.List;
import java.util.function.Consumer;
import java.util.function.Function;
import java.util.function.Supplier;

@SpringBootApplication
public class SpringBootLambdaApplication {

    public static void main(String[] args) {
        SpringApplication.run(SpringBootLambdaApplication.class, args);
    }

    @Bean
    public Function<String, String> reverse() {
        return (input) -> new StringBuilder(input).reverse().toString();
    }

    @Bean
    public Supplier<List<Book>> getBooks() {
        return () -> List.of(new Book(1, "Core Jave"),
                new Book(2, "Spring Boot"));
    }

    @Bean
    public Consumer<String> printBooks() {
        return (input) -> System.out.println(input);
    }

}
