package com.example.projeto_aguas_fluentes;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.scheduling.annotation.EnableAsync;

@SpringBootApplication
@EnableAsync
public class AguasFluentesApp {

    public static void main(String[] args) {
        SpringApplication.run(AguasFluentesApp.class, args);
    }
}
