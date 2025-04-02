package com.matth.tp_spring.exception;

public class InvalidHeroException extends Exception {
    public InvalidHeroException(String message) {
        super(message);
    }

    public static void VerifDonnees(String name, String universe, int powerLevel) throws InvalidHeroException {
        if(powerLevel<0) {
            throw new InvalidHeroException("Le niveau ne peut pas être négatif");
        }
        if(name.isEmpty()) {
            throw new InvalidHeroException("Le nom est requis");
        }
        if(universe.isEmpty()) {
            throw new InvalidHeroException("L'univers est requis");
        }
    }
}
