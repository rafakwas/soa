package lab3.zadanie3;

import java.util.HashMap;
import java.util.Map;

public class Validation {
    public static final Map<String,String> accounts;

    static {
        accounts = new HashMap<>();
        accounts.put("a","a");
        accounts.put("b","b");
        accounts.put("c","c");
    }

    public static boolean checkUser(String login, String password) {
        if (accounts.containsKey(login) && accounts.get(login).equals(password)) {
            return true;
        }
        return false;
    }
}
