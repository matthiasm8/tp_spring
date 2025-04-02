package com.matth.tp_spring.controller;

import com.matth.tp_spring.entity.Hero;
import com.matth.tp_spring.service.HeroService;
import jakarta.validation.Valid;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.MethodArgumentNotValidException;
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
    public ResponseEntity<?> addHero(@Valid @RequestBody Hero hero) {
        try {
            Hero newHero = heroService.addHero(hero);
            return ResponseEntity.ok(newHero);
        } catch (IllegalArgumentException e) {
            return ResponseEntity.badRequest().body(e.getMessage());
        }
    }

    // GET /api/heroes/{id} - Récupère un héros par ID
    @GetMapping("/{id}")
    public ResponseEntity<?> getHeroById(@PathVariable Long id) {
        Optional<Hero> hero = heroService.getHeroById(id);
        return hero.map(ResponseEntity::ok).orElseGet(() -> ResponseEntity.notFound().build());
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

    // Gestion des erreurs de validation
    @ExceptionHandler(MethodArgumentNotValidException.class)
    public ResponseEntity<String> handleValidationException(MethodArgumentNotValidException ex) {
        return ResponseEntity.badRequest().body("Erreur de validation : " + ex.getBindingResult().toString());
    }
}
