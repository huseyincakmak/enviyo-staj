package com.enviyo.staj.demo.deneme;


import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class DenemeController {

    @GetMapping("/demo")
    public String demoGet(){

        return "Merhaba Dünya";
    }

    @PostMapping("/demo")
    public String demoPost(@RequestBody String word){

        return "Gelen Istek: " + word;
    }

}
