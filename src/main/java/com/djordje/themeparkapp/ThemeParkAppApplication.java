package com.djordje.themeparkapp;

import com.djordje.themeparkapp.model.ThemeParkRide;
import com.djordje.themeparkapp.repository.ThemeParkRideRepository;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.Bean;

@SpringBootApplication
public class ThemeParkAppApplication {

    public static void main(String[] args) {
        SpringApplication.run(ThemeParkAppApplication.class, args);
    }


    @Bean
    public CommandLineRunner sampleData(ThemeParkRideRepository themeParkRideRepository) {
        return (args -> {
            themeParkRideRepository.save(new ThemeParkRide("RollerCoaster", "Train ride that speeds", 5, 3));
            themeParkRideRepository.save(new ThemeParkRide("Log flume", "Boat ride with pleanty of splashes", 3, 4));
            themeParkRideRepository.save(new ThemeParkRide("Teacups", "Spinning ride in giant tea-cup", 2, 2));
        });
    }

}
