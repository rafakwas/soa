package com.agh.edu.pl.soa.lab1.zadanie2;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.util.ArrayList;
import java.util.List;
import java.util.Random;

public class Zadanie2Model {
    String player;

    String computer;

    public Zadanie2Model(String player, String computer) {
        this.player = player;
        this.computer = computer;
    }

    public String getResponse() {
        switch (player) {
            case "papier":
                if (computer.equals("nozyce")) {
                    return "computer";
                }
                break;
            case "kamien":
                if (computer.equals("papier")) {
                    return "computer";
                }
                break;
            case "nozyce":
                if (computer.equals("kamien")) {
                    return "computer";
                }
                break;
        }
        return "player";
    }

}
