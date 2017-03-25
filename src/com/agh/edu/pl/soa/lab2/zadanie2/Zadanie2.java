package com.agh.edu.pl.soa.lab2.zadanie2;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;

@WebServlet(name = "zadanie2Controller", urlPatterns = {"lab2/zadanie2"})
public class Zadanie2 extends HttpServlet {
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {

    }
    // servlet wywoluje to co przygotuje mi widok przy pomocy tego co powie model
    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        response.setContentType("text/html");
        response.setCharacterEncoding("UTF-8");

        Zadanie2Model model = new Zadanie2Model(request.getParameter("player"),request.getParameter("computer"));
        String winner = model.getResponse();

        Zadanie2View view = new Zadanie2View();
        view.printResult(winner,response);

    }

}
