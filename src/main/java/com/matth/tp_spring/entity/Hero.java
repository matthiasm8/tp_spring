package com.matth.tp_spring.entity;

import com.matth.tp_spring.exception.InvalidHeroException;
import jakarta.persistence.*;

@Entity
public class Hero {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    private String name;
    private String universe;
    private int powerLevel;

    public Hero() {}

    public Hero(String name, String universe, int powerLevel) throws InvalidHeroException {
        InvalidHeroException.VerifDonnees(name,universe,powerLevel);
        this.name = name;
        this.universe = universe;
        this.powerLevel = powerLevel;
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getUniverse() {
        return universe;
    }

    public void setUniverse(String universe) {
        this.universe = universe;
    }

    public int getPowerLevel() {
        return powerLevel;
    }

    public void setPowerLevel(int powerLevel) {
        this.powerLevel = powerLevel;
    }

    @Override
    public String toString() {
        return "Hero{" +
                "id=" + id +
                ", name='" + name + '\'' +
                ", universe='" + universe + '\'' +
                ", powerLevel=" + powerLevel +
                '}';
    }
}

