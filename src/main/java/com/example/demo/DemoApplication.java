package com.example.demo;

import com.example.demo.item.Flower;
import com.example.demo.repository.FlowerRepository;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.Bean;

import java.util.List;

@SpringBootApplication
public class DemoApplication {

	public static void main(String[] args) {
		SpringApplication.run(DemoApplication.class, args);
	}

    @Bean
    CommandLineRunner commandLineRunner(FlowerRepository flowerRepository) {
        return args -> {
            Flower rose = new Flower(50, 2.50,"Red", "Rose");
            Flower tulip = new Flower(40, 1.75, "Yellow", "Tulip");
            Flower lily = new Flower(100, 3.00, "White", "Lily");

            flowerRepository.saveAll(List.of(rose, tulip, lily));
        };
    }

}
