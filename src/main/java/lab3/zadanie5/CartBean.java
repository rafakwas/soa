package lab3.zadanie5;

import javax.ejb.Stateful;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class CartBean implements CartInterface {
    private Map<Integer,Integer> cartMap = new HashMap<>();

    @Override
    public void add(Integer x) {
        if (!cartMap.containsKey(x)) {
            cartMap.put(x,1);
        }
        else {
            Integer amount = cartMap.get(x);
            cartMap.put(x,amount+1);
        }
    }

    @Override
    public void remove(Integer x) {
        if(cartMap.containsKey(x)) {
            if(!cartMap.remove(x,1)) {
                Integer amount = cartMap.get(x);
                cartMap.put(x,amount-1);
            }
        }
    }

    @Override
    public Map<Integer, Integer> getCart() {
        return cartMap;
    }
}
