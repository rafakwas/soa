package lab2.zadanie4.car;

import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.stream.Collectors;

class CarProperties {
    private Integer value;
    private final CarType type;

    public CarProperties(Integer value, CarType type) {
        this.value = value;
        this.type = type;
    }

    public void setValue(Integer value) {
        this.value = value;
    }

    public Integer getValue() {
        return value;
    }

    public CarType getType() {
        return type;
    }
}

enum CarType {
    sport,urban,luxurious
}

public class CarChoiceHelper {
    private static final Map<String,CarProperties> cars;
    static {
        cars = new HashMap<>();
        cars.put("Opel Ascona",new CarProperties(2000,CarType.urban));
        cars.put("Daewoo Matiz", new CarProperties(700,CarType.urban));
        cars.put("Hyundai Barnaba", new CarProperties(4000,CarType.urban));
        cars.put("Jaguar Jetto", new CarProperties(20000,CarType.sport));
        cars.put("Henryk Walezy", new CarProperties(20000,CarType.luxurious));
        cars.put("Tata Mombaj",new CarProperties(1500,CarType.urban));
        cars.put("Tesla D90", new CarProperties(30000,CarType.sport));
        cars.put("Rolls-Royce Phantom", new CarProperties(50000,CarType.luxurious));
        cars.put("Mercedes 780d", new CarProperties(40000,CarType.luxurious));
    }



    public List<String> getBestMatches(String type, String range) {

        String[] splitter = range.split("-");
        int min = Integer.parseInt(splitter[0]);
        int max = Integer.parseInt(splitter[1]);

        switch (type) {
            case "sport":
                return searchCars(CarType.sport,min,max);
            case "urban":
                return searchCars(CarType.urban,min,max);
            case "luxurious":
                return searchCars(CarType.luxurious,min,max);
        }
        throw new RuntimeException("Unidentyfied car type");
    }

    private List<String> searchCars(CarType type,int min, int max) {
        return cars.entrySet().stream()
                .filter(map -> map.getValue().getType().equals(type) &&
                        map.getValue().getValue() >= min &&
                        map.getValue().getValue() <= max
                )
                .map(map -> map.getKey())
                .collect(Collectors.toList());
    }
}
