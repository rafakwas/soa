package com.agh.edu.pl.soa.lab1.zadanie2;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.io.PrintWriter;

public class Zadanie2View {
    public void printResult(String winner, HttpServletResponse response) throws ServletException, IOException {
        PrintWriter out = response.getWriter();
        out.println("winner: " + winner);
        out.close();
    }

}
