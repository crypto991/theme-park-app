package com.djordje.themeparkapp.repository;


import com.djordje.themeparkapp.model.ThemeParkRide;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;

public interface ThemeParkRideRepository extends JpaRepository<ThemeParkRide, Long> {

    List<ThemeParkRide> findByName(String name);
}
