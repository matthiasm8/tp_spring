package com.matth.tp_spring.entity;

import jakarta.persistence.*;
import jakarta.validation.constraints.*;
import lombok.*;

@Data
@AllArgsConstructor
@NoArgsConstructor
@Entity
public class Hero {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @NotBlank
    private String name;

    @NotBlank
    private String universe;

    @Min(0)
    @Max(100)
    private int strength;

    @Min(0)
    @Max(100)
    private int defense;

    @Min(0)
    @Max(100)
    private int speed;

    @Min(0)
    @Max(100)
    private int accuracy;

    @Min(0)
    @Max(100)
    private int intelligence;

    @Min(0)
    @Max(100)
    private int luck;

    @Override
    public String toString() {
        return "Hero{" +
                "id=" + id +
                ", name='" + name + '\'' +
                ", universe='" + universe + '\'' +
                ", strength=" + strength +
                ", defense=" + defense +
                ", speed=" + speed +
                ", accuracy=" + accuracy +
                ", intelligence=" + intelligence +
                ", luck=" + luck +
                '}';
    }
}
