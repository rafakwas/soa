package com.agh.edu.pl.soa.lab3.zadanie1;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.io.PrintWriter;

@WebServlet(name = "WyborPiwa")
public class WyborPiwa extends HttpServlet {
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        response.setContentType("text/html");
        PrintWriter out = response.getWriter();
        out.println("Porada piwna<br/>");
        String c = request.getParameter("color");
        out.println("kolor" + c);

        EkspertPiwny ekspertPiwny = new EkspertPiwny(c);

        getServletContext().setAttribute("ekspert",ekspertPiwny);

        request.getRequestDispatcher("wyniki.jsp").forward(request,response);




    }

    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
    }
}
