package com.matth.tp_spring.service;

import com.matth.tp_spring.entity.Hero;
import com.matth.tp_spring.exception.InvalidHeroException;
import com.matth.tp_spring.repository.HeroRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;
import java.util.Random;

@Service
public class HeroService {

    @Autowired
    private HeroRepository heroRepository;

    // Ajouter un héros
    public Hero addHero(String name, String universe, int powerLevel) throws InvalidHeroException {
        Hero newHero = new Hero(name, universe, powerLevel);
        return heroRepository.save(newHero);
    }

    // Récupérer tous les héros
    public List<Hero> getHeroList() {
        return heroRepository.findAll();
    }

    // Récupérer un héros par ID
    public Optional<Hero> getHeroById(Long id) {
        return heroRepository.findById(id);
    }

    // Renvoie un héros aléatoire
    public Hero getRandomHero() {
        List<Hero> heroes = heroRepository.findAll();
        if (heroes.isEmpty()) {
            return null;
        }
        Random rand = new Random();
        return heroes.get(rand.nextInt(heroes.size()));
    }

    // Recherche partielle par nom
    public List<Hero> searchHeroesByName(String name) {
        return heroRepository.findByNameContainingIgnoreCase(name);
    }
}
