package com.agh.edu.pl.soa.lab1.zadanie6;

import java.util.*;
import java.util.stream.Collectors;

enum beerColors {
    yellow,red,black,brown,palebrown
}

public class EkspertPiwny {
    public EkspertPiwny(String color) {
        this.color = color;
    }

    private String color;




    public static final Map<String,String> beers;

    static {
        beers = new HashMap<>();
        beers.put("Tyskie","yellow");
        beers.put("Ognista wola","red");
        beers.put("Brązowy ogier","brown");
        beers.put("Czarna maź","black");

    }

    public List<String> chooseBeer(String color) {
        List<String> marki = beers.entrySet().stream()
                .filter(map -> map.getValue().equals(color))
                .map(map -> map.getKey())
                .collect(Collectors.toList());
        return marki;
    }


}
