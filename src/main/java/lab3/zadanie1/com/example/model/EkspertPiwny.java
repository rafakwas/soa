package lab3.zadanie1.com.example.model;

import java.util.*;
import java.util.stream.Collectors;

public class EkspertPiwny {

    public static final Map<String,String> piwa;

    static {
        piwa = new HashMap<>();
        piwa.put("Tyskie","yellow");
        piwa.put("Ognista wola","red");
        piwa.put("Brązowy ogier","brown");
        piwa.put("Czarna maź","black");

    }

    public List<String> marki(String kolor) {
        List<String> marki = piwa.entrySet().stream()
                .filter(map -> map.getValue().equals(kolor))
                .map(map -> map.getKey())
                .collect(Collectors.toList());
        return marki;
    }


}
