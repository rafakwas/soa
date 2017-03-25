package com.agh.edu.pl.soa.lab2.zadanie5;

import java.util.HashMap;
import java.util.Map;

public class Validation {
    public static final Map<String,String> accounts;

    static {
        accounts = new HashMap<>();
        accounts.put("ralphigi","abc");
        accounts.put("rafal","def");
        accounts.put("kwasnik","hgj");
    }

    public static boolean checkUser(String login, String password) {
        if (accounts.containsKey(login) && accounts.get(login).equals(password)) {
            return true;
        }
        return false;
    }
}
