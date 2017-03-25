package com.agh.edu.pl.soa.lab1.zadanie1;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.io.PrintWriter;

@WebServlet(name = "/test")
public class TestServlet extends HttpServlet {
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {

    }
// servlet wywoluje to co przygotuje mi widok przy pomocy tego co powie model
    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        response.setContentType("text/html");
        response.setCharacterEncoding("UTF-8");
        String name = request.getParameter("name");
        int age = Integer.parseInt(request.getParameter("age"));
        String gender = (isWoman(name)) ? "kobieta" : "mężczyzna";
        String ofAge = (isOfAge(age)) ? "pełnoletni/a" : "niepełnioletni/a";
        PrintWriter out = response.getWriter();
        out.println("Człowiek jest " + gender + ", " + ofAge);
        out.close();
    }

    public boolean isWoman(String name) {
        return (Character.compare(name.charAt(name.length()-1),'a') == 0) ? true : false;
    }

    public boolean isOfAge(int age) {
        return (age >= 18) ? true : false;
    }
}
