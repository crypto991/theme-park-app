package com.djordje.themeparkapp.controller;

import com.djordje.themeparkapp.model.ThemeParkRide;
import com.djordje.themeparkapp.repository.ThemeParkRideRepository;
import org.springframework.http.HttpStatus;
import org.springframework.http.MediaType;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.server.ResponseStatusException;

import java.util.List;

@RestController
public class ThemeParkRideController {


    private final ThemeParkRideRepository themeParkRideRepository;


    public ThemeParkRideController(ThemeParkRideRepository themeParkRideRepository) {
        this.themeParkRideRepository = themeParkRideRepository;
    }


    @GetMapping(value = "/ride", produces = MediaType.APPLICATION_JSON_VALUE)
    public List<ThemeParkRide> getRides() {
        return themeParkRideRepository.findAll();
    }

    @GetMapping(value = "/ride/{id}", produces = MediaType.APPLICATION_JSON_VALUE)
    public ThemeParkRide getRide(@PathVariable Long id) {
        return themeParkRideRepository.findById(id).orElseThrow(() -> new ResponseStatusException(HttpStatus.NOT_FOUND,
                String.format("Invalid ride id %s", id)));
    }

    @PostMapping(value = "/ride", consumes = MediaType.APPLICATION_JSON_VALUE,
            produces = MediaType.APPLICATION_JSON_VALUE)
    public ThemeParkRide getRide(@Validated @RequestBody ThemeParkRide themeParkRide) {
        return themeParkRideRepository.save(themeParkRide);
    }
}
