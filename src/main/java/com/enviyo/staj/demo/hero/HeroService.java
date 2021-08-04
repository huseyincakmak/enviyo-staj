package com.enviyo.staj.demo.hero;

import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;

@Service
public class HeroService {

    private static final List<Hero> HEROES = new ArrayList<>();

    static {
        HEROES.add(new Hero(11, "Dr Nice"));
        HEROES.add(new Hero(12, "Narco"));
        HEROES.add(new Hero(13, "Bombasto"));
        HEROES.add(new Hero(14, "Celeritas"));
        HEROES.add(new Hero(15, "Magneta"));
        HEROES.add(new Hero(16, "RubberMan"));
    }

    public List<Hero> getHeroes() {

        return HEROES;
    }
}
