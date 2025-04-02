package com.matth.tp_spring.controller;

import com.matth.tp_spring.entity.Hero;
import com.matth.tp_spring.exception.InvalidHeroException;
import com.matth.tp_spring.service.HeroService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Optional;

@RestController
@RequestMapping("/api/heroes")
public class HeroController {

    @Autowired
    private HeroService heroService;

    // GET /api/heroes - Liste tous les héros
    @GetMapping
    public List<Hero> getAllHeroes() {
        return heroService.getHeroList();
    }

    // POST /api/heroes - Ajoute un héros
    @PostMapping
    public Hero addHero(@RequestBody Hero hero) throws InvalidHeroException {
        return heroService.addHero(hero.getName(), hero.getUniverse(), hero.getPowerLevel());
    }

    // GET /api/heroes/{id} - Récupère un héros par ID
    @GetMapping("/{id}")
    public Hero getHeroById(@PathVariable Long id) {
        Optional<Hero> hero = heroService.getHeroById(id);
        return hero.orElse(null);
    }

    // GET /api/heroes/random - Renvoie un héros aléatoire
    @GetMapping("/random")
    public Hero getRandomHero() {
        return heroService.getRandomHero();
    }

    // GET /api/heroes/search?name=xxx - Recherche partielle par nom
    @GetMapping("/search")
    public List<Hero> searchHeroesByName(@RequestParam String name) {
        return heroService.searchHeroesByName(name);
    }
}
