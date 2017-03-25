package com.agh.edu.pl.soa.lab1.zadanie3;

import javax.print.attribute.standard.PrinterURI;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.io.PrintWriter;
import java.util.Collections;
import java.util.Enumeration;
import java.util.LinkedList;
import java.util.List;


@WebServlet(name = "/zadanie32")
public class Zadanie32 extends HttpServlet {
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        doGet(request,response);
    }

    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        response.setContentType("text/html");
        response.setCharacterEncoding("UTF-8");

        PrintWriter out = response.getWriter();


        Enumeration<String> parameters = request.getParameterNames();

        List<Double> parameterList = new LinkedList<Double>();
        Double number = 0.0;
        String parameter = new String();
        while(parameters.hasMoreElements()) {
            parameter = parameters.nextElement();
            try {
                number = Double.parseDouble(request.getParameter(parameter));
                parameterList.add(number);
            }
            catch (Exception e) {
                out.print("Wprowadziles zle dane zly czlowieku, sabotaż serwera aplikacyjnego");
                out.close();
                return;
            }
        }


        Collections.sort(parameterList);
        out.print(parameterList);
        out.close();
    }

}
