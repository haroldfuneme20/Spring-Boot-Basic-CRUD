package com.haroldfuneme.leanteach.crud;

import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.jdbc.core.JdbcTemplate;

import java.util.UUID;

@SpringBootApplication
public class CrudApplication{

    private JdbcTemplate template;

    public static void main(String[] args) {
        SpringApplication.run(CrudApplication.class, args);
    }
}
