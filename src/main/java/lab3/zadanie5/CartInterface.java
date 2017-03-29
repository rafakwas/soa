package lab3.zadanie5;

import java.util.Map;

public interface CartInterface {
    void add(Integer x);
    void remove(Integer x);
    Map<Integer,Integer> getCart();
}
