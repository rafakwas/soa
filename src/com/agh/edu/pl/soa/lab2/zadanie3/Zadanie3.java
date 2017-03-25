package com.agh.edu.pl.soa.lab2.zadanie3;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.io.PrintWriter;
import java.util.Enumeration;
import java.util.LinkedList;
import java.util.List;

@WebServlet(name = "zadanie31", urlPatterns = {"lab2/zadanie3"})
public class Zadanie3 extends HttpServlet {
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {

    }
    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        response.setContentType("text/html");
        response.setCharacterEncoding("UTF-8");
        PrintWriter out = response.getWriter();


        Enumeration<String> parameters = request.getParameterNames();
        if(request.getParameterMap().entrySet().size() == 5) {
            List<Integer> parameterList = new LinkedList<Integer>();

            while(parameters.hasMoreElements()) {
                parameterList.add(Integer.parseInt(request.getParameter(parameters.nextElement())));
            }

            Integer sum = 0;

            for (Integer element : parameterList) {
                sum += element;
            }

            Double average = (double)sum/(double)parameterList.size();

            out.println("average value of : " + parameterList + " \t is: " + average);
        } else {
            out.println("incorrent input");
        }
        out.close();


    }

}
