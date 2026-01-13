package com.example.anagrafica_dipendenti;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.ApplicationContext;
import org.springframework.context.annotation.Bean;
import org.springframework.boot.CommandLineRunner;

@SpringBootApplication
public class AnagraficaDipendentiApplication {

    public static void main(String[] args) {
        SpringApplication.run(AnagraficaDipendentiApplication.class, args);
    }

    @Bean
    public CommandLineRunner test(ApplicationContext ctx) {
        return args -> {
            System.out.println("=== CONTROLLERS REGISTRATI ===");
            for (String bean : ctx.getBeanDefinitionNames()) {
                if (bean.toLowerCase().contains("controller")) {
                    System.out.println(bean);
                }
            }
        };
    }
}
