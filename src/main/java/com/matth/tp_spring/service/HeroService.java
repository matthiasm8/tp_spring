package com.matth.tp_spring.service;

import com.matth.tp_spring.entity.Hero;
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

    public List<Hero> getHeroList() {
        return heroRepository.findAll();
    }

    public Hero addHero(Hero hero) {
        validateHero(hero);
        return heroRepository.save(hero);
    }

    public Optional<Hero> getHeroById(Long id) {
        return heroRepository.findById(id);
    }

    public Hero getRandomHero() {
        List<Hero> heroes = heroRepository.findAll();
        return heroes.get(new Random().nextInt(heroes.size()));
    }

    public List<Hero> searchHeroesByName(String name) {
        return heroRepository.findByNameContainingIgnoreCase(name);
    }

    // Méthode de validation
    private void validateHero(Hero hero) {
        if (hero.getStrength() < 0 || hero.getDefense() < 0 || hero.getSpeed() < 0 ||
                hero.getAccuracy() < 0 || hero.getIntelligence() < 0 || hero.getLuck() < 0) {
            throw new IllegalArgumentException("Tous les attributs doivent être positifs.");
        }
        if (hero.getName() == null || hero.getName().isBlank()) {
            throw new IllegalArgumentException("Le nom du héros doit être indiqué.");
        }

        if (hero.getUniverse() == null || hero.getUniverse().isBlank()) {
            throw new IllegalArgumentException("L'univers du héros doit être indiqué.");
        }

        int totalAttributes = hero.getStrength() + hero.getDefense() + hero.getSpeed() +
                hero.getAccuracy() + hero.getIntelligence() + hero.getLuck();

        if (totalAttributes != 300) {
            throw new IllegalArgumentException("La somme des attributs (force, défense, vitesse, précision, intelligence, chance) doit être égale à 300. Actuellement : " + totalAttributes);
        }
    }
}
