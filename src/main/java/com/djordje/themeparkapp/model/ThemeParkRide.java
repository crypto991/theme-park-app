package com.djordje.themeparkapp.model;

import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import lombok.ToString;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;

@Entity
@Getter
@ToString
@Setter
@NoArgsConstructor
public class ThemeParkRide {

    @Id
    @GeneratedValue
    private Long id;

    private String name;
    private String description;
    private Integer thrillFactor;
    private Integer vomitFactor;

    public ThemeParkRide(String name, String description, Integer thrillFactor, Integer vomitFactor) {
        this.name = name;
        this.description = description;
        this.thrillFactor = thrillFactor;
        this.vomitFactor = vomitFactor;
    }

}
