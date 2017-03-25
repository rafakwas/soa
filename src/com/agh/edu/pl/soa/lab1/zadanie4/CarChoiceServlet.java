package com.agh.edu.pl.soa.lab1.zadanie4;

import com.agh.edu.pl.soa.lab1.zadanie4.car.CarChoiceHelper;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.io.PrintWriter;
import java.util.Enumeration;
import java.util.List;

@WebServlet(name = "CarChoiceServlet")
public class CarChoiceServlet extends HttpServlet {
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        doGet(request,response);
    }

    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        PrintWriter out = response.getWriter();

        Enumeration<String> parameters = request.getParameterNames();

        while(parameters.hasMoreElements()) {
            String par = parameters.nextElement();
            String value = request.getParameter(par);
        }

        CarChoiceHelper carChoiceHelper = new CarChoiceHelper();
        System.out.println(request.getParameter("type"));
        List<String> bestMatches = carChoiceHelper.getBestMatches(request.getParameter("type"),request.getParameter("range"));

        out.println("best matches: " + bestMatches);

        out.close();
    }
}
