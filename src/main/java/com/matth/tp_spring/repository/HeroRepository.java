package com.matth.tp_spring.repository;

import com.matth.tp_spring.entity.Hero;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface HeroRepository extends JpaRepository<Hero, Long> {
    List<Hero> findByNameContainingIgnoreCase(String name);
}
