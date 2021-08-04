package com.enviyo.staj.demo.hero;

import lombok.RequiredArgsConstructor;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
@RequestMapping("/heroes")
@RequiredArgsConstructor
@CrossOrigin("*")
public class HeroController {

    private final HeroService heroService;

    @GetMapping
    public List<Hero> getHeroes() {

        return heroService.getHeroes();
    }

}
